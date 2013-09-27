package com.ulyanova.todo.web;

import com.ulyanova.todo.service.ToDoSamplesInit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class ToDoServlet extends HttpServlet {
    protected ActionFactory factory = new ActionFactory();
    public ToDoServlet (){
        super();
    }

    @Override
    public void init() throws ServletException {
        ToDoSamplesInit samplesInit = new ToDoSamplesInit();
        samplesInit.createTables("WORK","EDUCATION", "MISCELLANEOUS");
        try {
            samplesInit.insertToDoItems();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

        try {
            action.perform(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
