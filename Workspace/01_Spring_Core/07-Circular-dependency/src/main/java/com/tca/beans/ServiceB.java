package com.tca.beans;

public class ServiceB {

	private ServiceA serviceA;
	
	
	public ServiceB(ServiceA serviceA) {
		this.serviceA = serviceA;
	}
	
	public void display() {
		System.out.println("ServiceB's display");
		serviceA.show();
	}
	
	public void show() {
		System.out.println("ServiceB's show");
	}
	
}
