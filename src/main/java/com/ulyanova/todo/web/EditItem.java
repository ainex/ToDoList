package com.ulyanova.todo.web;

import com.ulyanova.todo.service.Controller;
import com.ulyanova.todo.service.ControllerImpl;
import com.ulyanova.todo.service.StringToDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

public class EditItem implements Action {


    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int TASK_DESCRIPTION_LENGTH = 128;
        Controller controller = new ControllerImpl();
        String folderName = request.getParameter("folderName");
        String  task = request.getParameter("task-description");
        if (task.length()>TASK_DESCRIPTION_LENGTH) {
            task = task.substring(0, TASK_DESCRIPTION_LENGTH);
        }
        String dateAndTimeStr = request.getParameter("exp-date") + " "
                +request.getParameter("exp-time");
        int id = Integer.parseInt(request.getParameter("id"));
        java.util.Date date;
        response.setContentType("text");
        PrintWriter out = response.getWriter();
        try {
            date = StringToDate.getDate(dateAndTimeStr);
            controller.updateToDoItem(id, date, task, folderName);
            out.print("Task was updated: " + task + " @ " + folderName + dateAndTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
            out.print("Incorrect date/time format. Please, try again with (dd.MM.yyyy HH:mm) ");
        }

        out.flush();
    }
}
