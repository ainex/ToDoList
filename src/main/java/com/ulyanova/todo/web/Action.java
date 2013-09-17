package com.ulyanova.todo.web;

import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 15.09.13
 * Time: 19:00
 * To change this template use File | Settings | File Templates.
 */
public interface Action {
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
