package com.tca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tca.beans.ServiceB;

@Configuration
@ComponentScan(basePackages = "com.tca")
public class AppConfig {

	@Bean
	public ServiceB serviceB( ) {
		System.out.println("Bean method");
		return new ServiceB();
	}
	
	
}
