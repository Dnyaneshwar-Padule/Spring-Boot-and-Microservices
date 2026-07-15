package com.tca.beans;

public class Travel {

	private Vehicle car;

	
	public void setCar(Vehicle vehicle) {
		this.car = vehicle;
	}
	
	public Vehicle setCar() {
		return car;
	}
	
	public void startJourney() {
		car.run();
	}
	
}
