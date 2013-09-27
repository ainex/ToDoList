package com.ulyanova.todo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public interface Action {
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException;
}
