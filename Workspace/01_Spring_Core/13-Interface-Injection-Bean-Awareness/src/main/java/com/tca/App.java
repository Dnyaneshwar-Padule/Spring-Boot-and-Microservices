package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.bean.HelloWorld;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
   
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    
    	applicationContext.getBean(HelloWorld.class).showAwarenessInfo();
    	
    	/*
    	 	A bean first get's it's name (BeanNameAware)
    	 	then it get's the reference of Container
    	 	
    	 	which makes sense, because suppose there are 100 beans and container will create them one-by-one
    	 	so, as it creates a bean, it will call it's setBeanName method, and at the end, it will set their applicationContext
    	 */
    	
    }
}
