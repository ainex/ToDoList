package com.ulyanova.todo.service;

import com.ulyanova.todo.dao.ItemDAOImpl;
import com.ulyanova.todo.domain.ToDoItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 13.09.13
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class ControllerImpl implements Controller {

    private ItemDAOImpl itemDAO = new ItemDAOImpl();

    @Override
    public void addToDoItem(Date expirationDate, String taskDescription, String table) throws SQLException {

        itemDAO.addToDoItem(expirationDate, taskDescription, table);
    }

    @Override
    public void removeToDoItem(int id) {

        itemDAO.removeToDoItem(id);
    }

    @Override
    public void updateToDoItem(int id, Date expirationDate, String taskDescription, String table) {

        itemDAO.updateToDoItem(id, expirationDate, taskDescription, table);
    }

    @Override
    public List<ToDoItem> getItems(String folderName) {

        return itemDAO.getItems(folderName);
    }

    @Override
    public JSONObject getJSONArray(List<ToDoItem> itemList) {
        JSONArray toDoItemsJSONArray = new JSONArray();
        JSONObject resultJson = new JSONObject();
        Map<String, String> itemMap=null;
        for (ToDoItem item: itemList) {

            try {
                itemMap = ItemToMapUtil.getMap(item);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            toDoItemsJSONArray.add(itemMap);
        }

        resultJson.put("toDoItemsJSONObj",toDoItemsJSONArray);
        return resultJson;
    }
}



