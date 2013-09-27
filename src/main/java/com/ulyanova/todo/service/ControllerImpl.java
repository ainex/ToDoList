package com.ulyanova.todo.service;

import com.ulyanova.todo.dao.ItemDAOImpl;
import com.ulyanova.todo.domain.ToDoItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.SQLException;
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
    public void removeToDoItem(int id, String table) {

        itemDAO.removeToDoItem(id, table);
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
    public void createTable(String tableName) {
        itemDAO.createTable(tableName);
    }

    @Override
   /*
    *   Parses java.util.List to
    *   JSONObject {"toDoItemsJSONObj": JSONArray of JSONObjects}
    *   JSONObject is a java.util.Map and JSONArray is a java.util.List
    */

    public JSONObject getJSONObject(List<ToDoItem> itemList) {
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



