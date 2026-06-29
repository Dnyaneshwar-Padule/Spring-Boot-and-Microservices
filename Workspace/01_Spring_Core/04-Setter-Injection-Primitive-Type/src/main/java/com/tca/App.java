package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.Customer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    	
    	Customer customer = (Customer) applicationContext.getBean("customer");
    	
    	System.out.println(customer.getId());
    	System.out.println(customer.getName());
    	
    }
}
