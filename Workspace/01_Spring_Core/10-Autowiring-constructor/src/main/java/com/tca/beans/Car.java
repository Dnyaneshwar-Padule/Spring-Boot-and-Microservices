package com.tca.beans;

public class Car {

	private Engine engine;

	//public Car() {}
	
	public Car(Engine engine) {
		super();
		this.engine = engine;
	}
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void start() {
		System.out.println("Car is started !");
		engine.run();
	}
	
}
