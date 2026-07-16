package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    	
    	System.out.println("\nSpring Container started !\n");
    	
    	((ClassPathXmlApplicationContext)applicationContext).close();
    	
    }
}
