package com.ulyanova.todo.web;

import com.ulyanova.todo.service.Controller;
import com.ulyanova.todo.service.ControllerImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 15.09.13
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class RemoveItem implements Action {

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Controller controller = new ControllerImpl();
        String folderName = request.getParameter("folderName");
        int id = Integer.parseInt(request.getParameter("id"));
        controller.removeToDoItem(id,folderName);
        response.setContentType("text");
        PrintWriter out = response.getWriter();
        out.print("Task @ "+ folderName + " id = " + id + " was deleted" );
        out.flush();
    }
}
