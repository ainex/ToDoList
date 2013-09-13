package com.ulyanova.todo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 12.09.13
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
public class StringToDate {

    public static Date getDate(String dateAndTimeStr) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat();
        formatter.applyPattern("dd.MM.yyyy HH:mm");
        java.util.Date dd = formatter.parse(dateAndTimeStr);

        return dd;
    }
}
