package com.tca.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Car implements Vehicle, BeanNameAware {
	
	@Autowired
//	@Qualifier("cngEngine")
	private Engine engine;
	
	@Override
	public void run() {
		engine.start();
		System.out.println("Car is running ! ");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Car : " + name);
	}

}
