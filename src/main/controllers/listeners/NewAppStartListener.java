package main.controllers.listeners;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by admin on 20.04.2017.
 */
public class NewAppStartListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        PropertyConfigurator.configure(NewAppStartListener.class.getClassLoader().getResource("log4j.xml"));
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
