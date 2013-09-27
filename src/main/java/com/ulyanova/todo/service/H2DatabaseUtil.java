package com.ulyanova.todo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DatabaseUtil {

    private static final String DRIVER_NAME = "org.h2.Driver";
    private static Connection dbConnection;

    static {

        try {
            Class.forName(DRIVER_NAME);
            dbConnection = DriverManager.getConnection("jdbc:h2:mem:toDoDatabase", "admin", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getDbConnection(){
        return dbConnection;
    }


}
