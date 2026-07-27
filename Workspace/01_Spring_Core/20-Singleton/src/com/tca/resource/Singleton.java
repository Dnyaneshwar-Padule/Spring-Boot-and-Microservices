package com.tca.resource;

public class Singleton {

	private static Singleton singleton;
	
	private Singleton() {
		System.out.println("Singleton.Singleton()");
	}
	
	public static Singleton getSingletonResource() {
		if(singleton == null) {
			synchronized (Singleton.class) {
				if(singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	
}
