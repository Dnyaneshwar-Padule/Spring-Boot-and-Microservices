package com.tca.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine, BeanNameAware{

	@Override
	public void start() {
		System.out.println("Petrol Engine is started !");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("PetrolEngine : " + name);
	}

}
