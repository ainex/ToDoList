package com.ulyanova.todo.web;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 17.09.13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class Log4jInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        String homeDir=event.getServletContext().getRealPath("/");
        File propertiesFile=new File(homeDir,"WEB-INF/log4j.properties");
        PropertyConfigurator.configure(propertiesFile.toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}
