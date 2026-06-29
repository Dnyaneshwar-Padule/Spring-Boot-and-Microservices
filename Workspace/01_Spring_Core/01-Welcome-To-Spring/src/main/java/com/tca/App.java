package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.WelcomeBean;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    
    	// Starting the Spring container
    	// On starting the Spring Container, it creates all the beans
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");    	
    	
    	WelcomeBean welcomeBean = (WelcomeBean)applicationContext.getBean("welcomeBean");
    	
    	System.out.println(welcomeBean.greet());
    	
    }
}
