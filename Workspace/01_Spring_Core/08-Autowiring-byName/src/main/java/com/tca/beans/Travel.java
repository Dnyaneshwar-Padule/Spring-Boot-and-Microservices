package com.tca.beans;

public class Travel {

	private Vehicle vehicle;

	
	public void setBike(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Vehicle getBike() {
		return vehicle;
	}
	
	public void setCar(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public Vehicle getCar() {
		return vehicle;
	}
	
	public void startJourney() {
		vehicle.run();
	}
	
}
