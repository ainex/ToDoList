package com.ulyanova.todo.web;

import com.ulyanova.todo.service.ToDoSamplesInit;
import org.json.simple.JSONObject;

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
    protected ActionFactory factory = new ActionFactory();
    public ToDoServlet (){
        super();
    }

    @Override
    public void init() throws ServletException {
        ToDoSamplesInit samplesInit = new ToDoSamplesInit();
        samplesInit.createTables("WORK","EDUCATION", "MISCELLANEOUS");
        samplesInit.insertToDoItems();
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


        Action action = factory.create(getActionName(req));

        action.perform(req, resp);
        /*PrintWriter writer = resp.getWriter();
        JSONObject resultJson = new JSONObject();

        resultJson.put("name",actionName);
        writer.println(resultJson.toString());
        writer.close();*/

    }
}
