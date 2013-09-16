package com.ulyanova.todo.service;


import com.ulyanova.todo.domain.ToDoItem;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 13.09.13
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class DaoTestDrive {

    public static void main (String[] args) throws ParseException {
        ControllerImpl controller = new ControllerImpl();

        ToDoSamplesInit samplesInit = new ToDoSamplesInit();
        samplesInit.createTables("WORK","EDUCATION", "MISCELLANEOUS");
        samplesInit.insertToDoItems();

        List<ToDoItem> itemList = controller.getItems("EDUCATION");
        for (ToDoItem item : itemList) {
            System.out.println(item.itemToString());
        }

        Date newExpDate = StringToDate.getDate("17.09.2013 22:21");
        SimpleDateFormat ft =
                new SimpleDateFormat("dd.MM.yyyy HH:mm");
        controller.updateToDoItem(2, newExpDate, "new description", "EDUCATION");

        itemList = controller.getItems("EDUCATION");
        for (ToDoItem item : itemList) {
            System.out.println(item.itemToString());
            try {
                ItemToMapUtil.getMap(item);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }





    }
}
