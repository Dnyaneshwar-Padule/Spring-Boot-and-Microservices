package com.tca.entity;

public class Student {

	private String name;
	private String city;
	private Double per;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPer() {
		return per;
	}
	public void setPer(Double per) {
		this.per = per;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", city=" + city + ", per=" + per + "]";
	}
	
}
