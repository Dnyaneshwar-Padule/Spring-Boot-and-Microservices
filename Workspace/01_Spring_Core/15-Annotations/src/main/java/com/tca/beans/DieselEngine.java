package com.tca.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DieselEngine implements Engine, BeanNameAware {

	@Override
	public void start() {
		System.out.println("Diesel engine is started !");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("DieselEngine : " + name );
	}

}
