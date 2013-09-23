package com.ulyanova.todo.dao;

import com.ulyanova.todo.domain.ToDoItem;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 07.09.13
 * Time: 19:49
 * To change this template use File | Settings | File Templates.
 */
public interface ItemDAO {


    public void addToDoItem(Date expirationDate, String taskDescription, String table) throws SQLException;
    public void removeToDoItem(int id, String table);
    public void updateToDoItem(int id, Date expirationDate, String taskDescription, String table);
    public List<ToDoItem> getItems(String folderName);
    public void createTable(String tableName);
}
