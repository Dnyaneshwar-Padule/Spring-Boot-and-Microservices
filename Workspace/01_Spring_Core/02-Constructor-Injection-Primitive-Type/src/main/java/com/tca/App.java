package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tca.beans.Customer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
//    	BeanFactory applicationContext = new ClassPathXmlApplicationContext("config.xml");
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");        

    	System.out.println("Container is started.......");
    	
    	Customer customer = (Customer) applicationContext.getBean("customer");
    	
    	System.out.println("Bean is requested !");
    	
    	System.out.println("Customer Id: "  + customer.getId());
    	System.out.println("Customer name: " + customer.getName());
    	
    	System.out.println();
    	new Demo();
    	System.out.println();
    	new Demo();
    	System.out.println();
    	new Demo();
    	
    }
}
