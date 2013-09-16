package com.ulyanova.todo.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 12.09.13
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public class ToDoServlet extends HttpServlet {

    public ToDoServlet (){
        super();
    }

    protected String getActionName(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.substring(path.lastIndexOf(".")+1, path.length());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String actionName = getActionName(req);
        PrintWriter writer = resp.getWriter();
        writer.println("Hello, World!");
        writer.close();

    }
}
