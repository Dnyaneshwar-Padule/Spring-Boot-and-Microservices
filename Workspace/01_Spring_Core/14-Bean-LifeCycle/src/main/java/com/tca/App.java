package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    	
    	System.out.println("\nContainer is started !!!\n");

    	((ClassPathXmlApplicationContext)applicationContext).close();
    	
    	/*
    	 		The bean life-cycle 
    				
    				1. Bean Creation (call for default or parameterized constructor)
    				2. Setter injection
    				3. BeanNameAware (setBeanName())
    				4. ApplicationContextAware (setApplicationContext())
    				5. InitializingBean (afterPropertiesSet())
    				6. Custom init method (myInit())
    				
    				7. DisposableBean (destroy())
    				8. Custom destroy method (myDestroy())
    	 */
    	
    }
}
