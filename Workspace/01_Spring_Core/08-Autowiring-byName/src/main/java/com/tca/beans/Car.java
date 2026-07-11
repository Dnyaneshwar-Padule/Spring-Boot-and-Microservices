package com.tca.beans;

public class Car implements Vehicle {

	@Override
	public void run() {
		System.out.println("Travelling via car !");
	}

}
