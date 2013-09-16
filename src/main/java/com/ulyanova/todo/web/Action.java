package com.ulyanova.todo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 15.09.13
 * Time: 19:00
 * To change this template use File | Settings | File Templates.
 */
public interface Action {
    public String perform(HttpServletRequest request, HttpServletResponse response);
}
