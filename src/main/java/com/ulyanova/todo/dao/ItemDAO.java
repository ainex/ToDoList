package com.ulyanova.todo.dao;

import com.ulyanova.todo.domain.ToDoItem;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ItemDAO {


    public void addToDoItem(Date expirationDate, String taskDescription, String table) throws SQLException;
    public void removeToDoItem(int id, String table);
    public void updateToDoItem(int id, Date expirationDate, String taskDescription, String table);
    public List<ToDoItem> getItems(String folderName);
    public void createTable(String tableName);
}
