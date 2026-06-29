package com.tca.beans;

public class Customer {

	private int id;
	private String name;
	
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("Customer object initialized...");
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
}
