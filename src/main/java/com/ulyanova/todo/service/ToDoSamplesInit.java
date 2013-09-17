package com.ulyanova.todo.service;

import com.ulyanova.todo.dao.ItemDAOImpl;

import java.sql.*;
import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 07.09.13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class ToDoSamplesInit {
    private ItemDAOImpl  itemDAO;
    private Statement statement;

    public ToDoSamplesInit() {
        this.itemDAO = new ItemDAOImpl();
    }

    public void createTables(String table1, String table2, String table3){
        itemDAO.createTables(table1, table2, table3);

    }

    public void insertToDoItems() {

        String description = "Study JSON objects";
        java.util.Date expirationDate = null;
        try {
            expirationDate = StringToDate.getDate("20.09.2013 20:05");
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        itemDAO.addToDoItem(expirationDate, description, "EDUCATION");
        itemDAO.addToDoItem(expirationDate, "write JSON ajax request", "EDUCATION");
        itemDAO.addToDoItem(expirationDate, "Metting: new project", "WORK");
    }
}
