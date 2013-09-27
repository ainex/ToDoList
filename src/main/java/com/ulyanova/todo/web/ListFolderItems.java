package com.ulyanova.todo.web;

import com.ulyanova.todo.domain.ToDoItem;
import com.ulyanova.todo.service.Controller;
import com.ulyanova.todo.service.ControllerImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListFolderItems implements Action {


    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Controller controller = new ControllerImpl();
        String folderName = request.getParameter("folderName");
        List<ToDoItem> itemsList = controller.getItems(folderName);
        /*
        *   JSONObject is a java.util.Map and JSONArray is a java.util.List
        *   Convert java.util.List to
        *   JSONObject {"toDoItemsJSONObj": JSONArray of JSONObjects}
        */

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(controller.getJSONObject(itemsList));
        out.flush();

    }
}
