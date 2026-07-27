package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tca.config.AppConfig;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    	
    	/*
    	 
    	 -- While Bean creation, the container first creates beans from component scanning, 
    	 	then it creates beans from bean methods 
    	 
    	 -- If a bean is created with component scan and another bean is created from bean method,
    	 	and if they both have same IDs (names) then container creates the bean from the bean method, (not component scan)
    	 	(here, the type of those beans can be different..........)
    	 	
    	 -- Container first tries to create a bean from byType, if it sees there are multiple qualifying beans
    	 	then it goes with byName, if it does not found any bean with byName, it throws exception....(UnsatisfiedDependencyException)
    	 
    	 
    	 
    	 */
    	
    }
}
