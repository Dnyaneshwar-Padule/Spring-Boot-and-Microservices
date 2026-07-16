package com.tca.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle, BeanNameAware {
	
	@Autowired
	@Qualifier("petrolEngine")
	private Engine engine;
	
	@Override
	public void run() {
		engine.start();
		System.out.println("Bike is running ! ");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Bike : " + name );
	}
	
}
