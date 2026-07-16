package com.tca.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
/*
	Used to tell the Spring Container that this class is an configuration class, and it should create beans according to this clas
	with component scanning and bean methods.
 */


@ComponentScan(basePackages = "com.tca")
/*
 	Used to scan beans (Component) within a package (base package)
 	
 	It's repeatable, we can use it repeatedly for multiple base packages
 	
 	attributes:
 	 	basePackages: It's like alias for id/name accepts String array, 
 	 		we can provide one or multiple base packages
 */
public class AppConfig {

	@Bean("places")
	/*
	 	If there is a dependency which is a predefined class like ArrayList, then we can't use component for it
	 	then to create spring beans for these these buil-in classes, we have to use @Bean annotation with a method 
	 	which will return the required bean.
	 	
	 	 attributes:
	 	 	name: it's like the id for that bean, if not given the method name becomes the name/id
	 */
	public List<String> getPlaces(){
		ArrayList<String> l = new ArrayList<>();
		l.add("Pune");
		l.add("Lonavala");
		return l;
	}
}
