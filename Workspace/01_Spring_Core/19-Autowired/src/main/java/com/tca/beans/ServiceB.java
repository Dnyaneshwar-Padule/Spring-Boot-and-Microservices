package com.tca.beans;

import org.springframework.stereotype.Component;

@Component
public class ServiceB {

	static int c;
	
	static {
		System.out.println("ServiceB.static{})");
	}
	
	public ServiceB() {
		System.out.println("ServiceB.ServiceB()");
	}
}
