package com.ulyanova.todo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 07.09.13
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
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
