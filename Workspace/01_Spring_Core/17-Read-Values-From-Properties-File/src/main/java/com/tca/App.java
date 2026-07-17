package com.tca;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tca.beans.AdminService;
import com.tca.beans.EmailService;
import com.tca.config.AppConfig;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	System.out.println( applicationContext.getBean(AdminService.class) );
    	System.out.println( applicationContext.getBean(EmailService.class) );
 
    	/**
    	 
    	 To tell the container to inject values from a properties file,
    	 we use @PropertySource annotation along with the name of properties file,
    	 which is in the resources folder
    	 
    	 We define this annotation in Configuration file
    	 
    	There can be multiple @PropertySource annotation in a configuration file, it is repeatable
    	
    	and to inject the values, we use @Value annotation for a field (where we want to inject value)
    	with the specifying the key of the value in ${}, (e.g. ${keyOfValue})
    	
    	properties file can have duplicate keys, spring won't throw exception, but while injecting the value, 
    	spring will use the last value, (values will be overwritten on for duplicate keys)
    	
    	if there is no key, spring will use "${keyOfValue}" as literal String to inject in the field,
    	here we can get an exception if the field is not of String type.
    	 
    	 */
    }
    
}
