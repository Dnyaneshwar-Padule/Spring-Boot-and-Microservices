package com.tca.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ServiceB {

	public ServiceB() {
		System.out.println("ServiceB.ServiceB()");
	}
	
}
