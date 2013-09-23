package com.ulyanova.todo.dao;



import com.ulyanova.todo.domain.ToDoItem;
import com.ulyanova.todo.service.H2DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 06.09.13
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class ItemDAOImpl implements ItemDAO {

    Connection dbConnection;

    public ItemDAOImpl() {
        this.dbConnection  = H2DatabaseUtil.getDbConnection();
    }

    @Override
    public void addToDoItem(Date expirationDate, String taskDescription, String table) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(table).append(" (entryDate, expDate, description) VALUES (?,?,?)");
        String sqlItemAdd = sb.toString();
        java.util.Date date = new java.util.Date();

        Timestamp entryDateSQL = new Timestamp(date.getTime());
        Timestamp expirationDateSQL = new Timestamp(expirationDate.getTime());

        try(PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlItemAdd)) {
            preparedStatement.setTimestamp(1, entryDateSQL);
            preparedStatement.setTimestamp(2, expirationDateSQL);
            preparedStatement.setString(3, taskDescription);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeToDoItem(int id, String table) {

        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ").append(table).append(" WHERE ID=").append(id);
        try {
            Statement st = dbConnection.createStatement();
            st.execute(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(id +"-number is deleted");

    }

    @Override
    public void updateToDoItem(int id, java.util.Date expirationDate, String taskDescription, String table) {
        //Table columns: (ID INT PRIMARY KEY AUTO_INCREMENT, entryDate DATETIME, expDate DATETIME, description VARCHAR(128))
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(table).append(" SET expDate=?, description=? WHERE ID=?");
        String sqlItemAdd = sb.toString();
        Timestamp expirationDateSQL = new Timestamp(expirationDate.getTime());

        try(PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlItemAdd)) {
            preparedStatement.setTimestamp(1, expirationDateSQL);
            preparedStatement.setString(2, taskDescription);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sb.setLength(0);

    }

    @Override
    public List<ToDoItem> getItems(String tableName) {
        List<ToDoItem> itemList = new ArrayList<ToDoItem>();
        try {
            Statement st = dbConnection.createStatement();
            ResultSet requestResults = st.executeQuery("SELECT * FROM "+tableName);

            while (requestResults.next()){
                int id = requestResults.getInt("ID");
                Date date = requestResults.getTimestamp("entryDate");
                Date expDate = requestResults.getTimestamp("expDate");
                String description = requestResults.getString("description");
                ToDoItem toDoItem = new ToDoItem(id, date, expDate, description);
                itemList.add(toDoItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }

    @Override
    public void createTable(String tableName) {
        Statement statement;
        try {
            statement = dbConnection.createStatement();
            statement.execute("CREATE TABLE "+tableName+ " " +
                    "(ID INT PRIMARY KEY AUTO_INCREMENT, entryDate DATETIME, expDate DATETIME, description VARCHAR(128))");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
