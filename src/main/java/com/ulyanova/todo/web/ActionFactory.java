package com.ulyanova.todo.web;

import java.util.HashMap;
import java.util.Map;


public class ActionFactory {
    protected Map map = defaultMap();

    public ActionFactory() {
        super();
    }
    public Action create(String actionName) {
        Class className = (Class) map.get(actionName);
        if (className == null)
            throw new RuntimeException(getClass() + " there is no any action named '" + actionName + "'.");

        Action actionInstance = null;
        try {
            actionInstance = (Action) className.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return actionInstance;
    }
    protected Map defaultMap() {
        Map map = new HashMap();

        map.put("add", AddItem.class);
        map.put("edit", EditItem.class);
        map.put("remove", RemoveItem.class);
        map.put("listFolderItems", ListFolderItems.class);

        return map;
    }
}
