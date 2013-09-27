package com.ulyanova.todo.service;

import com.ulyanova.todo.domain.ToDoItem;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 *   Parses ToDoItem  to java.util.Map. Used by Controller method
 *   public JSONObject getJSONObject(List<ToDoItem> itemList).
 *   JSONObject as {"toDoItemsJSONObj": JSONArray of JSONObjects}
 *   JSONObject is a java.util.Map and JSONArray is a java.util.List
 *
 */

public class ItemToMapUtil {

    public static Map <String, String> getMap (ToDoItem item) throws IllegalAccessException {
        SimpleDateFormat ft =
                new SimpleDateFormat("dd.MM.yyyy HH:mm");

        Map <String, String> itemToMap = new HashMap<>() ;

        Class c = item.getClass();
        Field[] declaredFields = c.getDeclaredFields();
        String nameValue;
        for (Field field : declaredFields) {
            nameValue = "";
            field.setAccessible(true);
            Class fieldType = field.getType();
            if (fieldType.getName().equals("int")) {
                nameValue = Integer.toString((int)field.get(item));

            }   else
                if (fieldType.getName().equals("java.util.Date")) {
                    nameValue = ft.format(field.get(item));

                } else {
                      nameValue = (String)field.get(item);
                   }

            itemToMap.put(field.getName(), nameValue);
        }

        return itemToMap;
    }
}
