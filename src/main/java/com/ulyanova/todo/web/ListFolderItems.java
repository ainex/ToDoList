package com.ulyanova.todo.web;

import com.ulyanova.todo.domain.ToDoItem;
import com.ulyanova.todo.service.Controller;
import com.ulyanova.todo.service.ControllerImpl;
import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 15.09.13
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class ListFolderItems implements Action {

    private static Logger logger=Logger.getLogger("simple");
    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Controller controller = new ControllerImpl();
        String folderName = request.getParameter("folderName");
        List<ToDoItem> itemsList = controller.getItems(folderName);
        /*
        *   JSONObject is a java.util.Map and JSONArray is a java.util.List
        *   Convert java.util.List to
        *   JSONObject {"toDoItemsJSONObj": JSONArray of JSONObjects}
        *   */
        //String jsonString = controller.getJSONArray(itemsList).toString();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(controller.getJSONArray(itemsList));
        out.flush();

    }
}
