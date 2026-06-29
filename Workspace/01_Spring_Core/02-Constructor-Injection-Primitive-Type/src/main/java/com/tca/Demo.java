package com.tca;

public class Demo {

	private int i = DemoUtil.getVal();
	
	static {
		System.out.println("Demo: static block");
	}
	
	{
		System.out.println("Demo: Anonymous Block");
	}
	
	public Demo() {
		System.out.println("Demo: No-Args constructor");
		i = 99;
	}
	
}
