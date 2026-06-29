package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.ServiceA;
import com.tca.beans.ServiceB;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

    		
    	/*
    	 	Circular dependency occurs when two or more than two classes have dependency with each other in circular manner 
    	 	and all dependent classes use constructor injection to inject dependency classes.
    	 
    	 	Note :
    	 		1. To resolve circular dependency, at least one dependent class should use setter injection 
    	 			to inject it's dependency object
    	 		2. The class which uses setter injection should be written first in config.xml
    	 			(before all classes).
    	 */
    	
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    	
    	ServiceA serviceA = (ServiceA) applicationContext.getBean("serviceA");
    	serviceA.display();
    	
    	ServiceB serviceB = (ServiceB) applicationContext.getBean("serviceB");
    	serviceB.display();
    }
}
