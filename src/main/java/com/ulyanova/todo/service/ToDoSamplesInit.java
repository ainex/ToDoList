package com.ulyanova.todo.service;


import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 07.09.13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class ToDoSamplesInit {
    private Controller  controller;

    public ToDoSamplesInit() {
        this.controller = new ControllerImpl();
    }

    public void createTables(String table1, String table2, String table3){
        controller.createTable(table1);
        controller.createTable(table2);
        controller.createTable(table3);

    }

    public void insertToDoItems() throws SQLException {
        java.util.Date expirationDate1 = null;
        java.util.Date expirationDate2 = null;
        java.util.Date expirationDate3 = null;
        try {
            expirationDate1 = StringToDate.getDate("25.09.2013 11:30");
            expirationDate2 = StringToDate.getDate("20.09.2013 10:00");
            expirationDate3 = StringToDate.getDate("27.09.2013 14:00");
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        controller.addToDoItem(expirationDate1, "Study jquery ajax request", "EDUCATION");
        controller.addToDoItem(expirationDate2, "Write ajax request with JSON", "EDUCATION");
        controller.addToDoItem(expirationDate3, "Meeting: new project", "WORK");
        controller.addToDoItem(expirationDate1, "Do shopping routine", "MISCELLANEOUS");
    }
}
