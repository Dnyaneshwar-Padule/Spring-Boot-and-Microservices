package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tca.beans.ServiceB;
import com.tca.config.AppConfig;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    	/*
    		ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(AppConfig.class);
			// every container creates it's own beans.
		*/
    	
    	
    	/*
    	 	There are 5 types of bean scopes
    	 		1. singleton
    	 		2. prototype
    	 		3. session
    	 		4. request
    	 		5. application
    	 		
    	 	-- By default, the scope is singleton.
    	 	
    	 	1. Singleton
    	 		-- In Singleton scope, all the beans are created at the time when the container is created/started.
    	 		-- We get the reference of same object whenever we request it.
    	 		-- It is singleton object per container( i.e. every container creates it's own beans ).
    	 		
    	 	2. Prototype
    	 		-- In prototype, we get a new object every time we request it.
    	 		-- A new object is created 2 times, 
    	 			1. when we request it to the container
    	 			2. when a dependent bean request it for.
    	 */
    	
    	
    	
    	System.out.println("Container created !");
    	ServiceB b = applicationContext.getBean(ServiceB.class);  // bean created when we request it.....
    	
    }
}
