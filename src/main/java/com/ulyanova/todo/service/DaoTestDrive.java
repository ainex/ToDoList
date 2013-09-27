package com.ulyanova.todo.service;


import com.ulyanova.todo.domain.ToDoItem;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DaoTestDrive {

    public static void main (String[] args) throws ParseException, SQLException {
        ControllerImpl controller = new ControllerImpl();

        ToDoSamplesInit samplesInit = new ToDoSamplesInit();
        samplesInit.createTables("WORK","EDUCATION", "MISCELLANEOUS");
        samplesInit.insertToDoItems();

        List<ToDoItem> itemList = controller.getItems("EDUCATION");
        for (ToDoItem item : itemList) {
            System.out.println(item.itemToString());
        }

        Date newExpDate = StringToDate.getDate("30.09.2013 22:21");
        SimpleDateFormat ft =
                new SimpleDateFormat("dd.MM.yyyy HH:mm");
        controller.updateToDoItem(2, newExpDate, "new description", "EDUCATION");

        itemList = controller.getItems("EDUCATION");


    }
}
