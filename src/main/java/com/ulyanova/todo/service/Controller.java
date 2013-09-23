package com.ulyanova.todo.service;

import com.ulyanova.todo.domain.ToDoItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 15.09.13
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
public interface Controller {

    public void addToDoItem(Date expirationDate, String taskDescription, String table) throws SQLException;
    public void removeToDoItem(int id, String table);
    public void updateToDoItem(int id, Date expirationDate, String taskDescription, String table);
    public void createTable(String tableName);
    public List<ToDoItem> getItems(String folderName);
    public JSONObject getJSONArray (List<ToDoItem> itemList);
}
