package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tca.config.AppConfig;
import com.tca.controller.ConsoleController;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	ApplicationContext  applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    
    	applicationContext.getBean(ConsoleController.class).start();;
    	
    }
}
