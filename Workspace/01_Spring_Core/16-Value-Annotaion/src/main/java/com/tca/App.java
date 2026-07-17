package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tca.beans.AdminService;
import com.tca.config.AppConfig;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	System.out.println( applicationContext.getBean(AdminService.class) );
    }
}
