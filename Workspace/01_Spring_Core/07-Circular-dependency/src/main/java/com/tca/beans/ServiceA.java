package com.tca.beans;

public class ServiceA {

	private ServiceB serviceB;
	
	public void setServiceB(ServiceB serviceB) {
		this.serviceB = serviceB;
	}
	
	public void show() {
		System.out.println("ServiceA's show");
	}
	
	public void display() {
		System.out.println("ServiceA's display");
		serviceB.show();
	}
}
