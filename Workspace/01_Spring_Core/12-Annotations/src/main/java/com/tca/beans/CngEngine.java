package com.tca.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class CngEngine implements Engine, BeanNameAware{

	public void start() {
		System.out.println("CNG Engine is started !");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("CngEngine : " + name );
	}
	
}
