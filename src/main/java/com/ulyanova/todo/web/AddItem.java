package com.ulyanova.todo.web;

import com.ulyanova.todo.service.ControllerImpl;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 15.09.13
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class AddItem implements Action  {
    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) {
        ControllerImpl controller = new ControllerImpl();
        /*   JSONObject is a java.util.Map and JSONArray is a java.util.List*/
      //  JSONObject jObj = new JSONObject(request.getParameter("mydata")); // this parses the json
       /* Iterator it = jObj.keys(); //gets all the keys

        while(it.hasNext())
        {
            String key = it.next(); // get key
            Object o = jObj.get(key); // get value
            session.putValue(key, o); // store in session
        }
        //controller.addToDoItem("");    */

}

}
