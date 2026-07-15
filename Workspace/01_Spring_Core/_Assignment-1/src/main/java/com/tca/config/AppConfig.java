package com.tca.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tca.entity.Student;

@Configuration
@ComponentScan(basePackages = "com.tca")
public class AppConfig {

	@Bean
	public HashMap<String, Student> studentStore(){
		return new HashMap<String, Student>();
	}
	
	@Bean
	public BufferedReader reader() {
		return new BufferedReader(consoleReader());
	}
	
	@Bean
	public InputStreamReader consoleReader() {
//		System.out.println("AppConfig.consoleReader()");
		return new InputStreamReader(System.in);
	}
}
