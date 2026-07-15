package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.ReportManager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    	
    	applicationContext.getBean(ReportManager.class).createReport();
    	
    }
}
