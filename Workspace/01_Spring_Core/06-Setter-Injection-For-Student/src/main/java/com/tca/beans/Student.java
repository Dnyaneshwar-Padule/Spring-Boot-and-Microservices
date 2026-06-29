package com.tca.beans;

public class Student {
	
	private int rno;
	private String name;
	private double fees;
	private String passport;
	
	public Student(int rno, String name, double fees) {
		this.rno = rno;
		this.name = name;
		this.fees = fees;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public int getRno() {
		return rno;
	}

	public String getName() {
		return name;
	}

	public double getFees() {
		return fees;
	}
	
}
