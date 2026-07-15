package com.tca.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bus implements Vehicle, BeanNameAware{

	@Autowired
	@Qualifier("dieselEngine")
	private Engine engine;
	
	@Override
	public void run() {
		engine.start();
		System.out.println("Bus is running ! ");
	
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Bus : " + name );
	}
}
