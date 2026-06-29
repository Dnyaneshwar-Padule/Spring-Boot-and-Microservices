package com.tca.beans;

public class Address {
	
	private String pincode;
	private String city;
	
	public Address(String city, String pincode) {
		this.city = city;
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}
	
	public String getPincode() {
		return pincode;
	}

}
