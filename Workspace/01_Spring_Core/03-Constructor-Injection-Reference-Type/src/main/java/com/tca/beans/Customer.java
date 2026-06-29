package com.tca.beans;

public class Customer {

	private int id;
	private String name;
	private Address address;
	
	public Customer(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}
}
