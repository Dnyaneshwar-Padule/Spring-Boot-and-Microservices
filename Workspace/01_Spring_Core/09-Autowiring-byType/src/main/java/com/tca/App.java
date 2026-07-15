package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.ReportGenerator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    	
    	ReportGenerator reportGenerator = applicationContext.getBean(ReportGenerator.class);
    	reportGenerator.generateReport();
    	
    }
}
