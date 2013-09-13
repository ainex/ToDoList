package com.ulyanova.todo.service;

import com.ulyanova.todo.dao.ItemDAOImpl;
import com.ulyanova.todo.domain.ToDoItem;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 13.09.13
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class ControllerImpl {

    public static void main (String[] args){

        Connection dbConnection = H2DatabaseUtil.getDbConnection();
        ToDoSamplesInit samplesInit = new ToDoSamplesInit(dbConnection);
        samplesInit.createTables();
        samplesInit.insertToDoItems();
        ItemDAOImpl dao = new ItemDAOImpl(dbConnection);
        List<ToDoItem> itemList = dao.getItems("WORK");
        for (ToDoItem item : itemList) {
            System.out.println(item.itemToString());
        }
        SimpleDateFormat ft =
                new SimpleDateFormat("dd.MM.yyyy HH:mm");

        try {
            System.out.println(ft.format(StringToDate.getDate("12.09.2013 21:13")));
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
