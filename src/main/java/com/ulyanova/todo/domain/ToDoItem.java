package com.ulyanova.todo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoItem {
    private int id;
    private Date entryDate;
    private Date expDate;
    private String description;

    public ToDoItem(int id, Date entryDate, Date expDate, String description) {
        this.id = id;
        this.entryDate = entryDate;
        this.expDate = expDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String itemToString (){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat ft =
                new SimpleDateFormat("dd.MM.yyyy HH:mm");

        sb.append(getId()).append(" ")
                .append(ft.format(getEntryDate())).append(" ")
                .append(ft.format(getExpDate())).append(" ")
                .append(getDescription());
        return  sb.toString();


    }
}
