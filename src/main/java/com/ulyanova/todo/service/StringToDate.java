package com.ulyanova.todo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {

    public static Date getDate(String dateAndTimeStr) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat();
        formatter.applyPattern("dd.MM.yyyy HH:mm");
        java.util.Date dd = formatter.parse(dateAndTimeStr);

        return dd;
    }
}
