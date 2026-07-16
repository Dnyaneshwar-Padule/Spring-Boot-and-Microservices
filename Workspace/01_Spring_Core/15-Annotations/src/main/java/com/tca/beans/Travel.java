package com.tca.beans;

import java.util.List;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Travel implements BeanNameAware{

	@Autowired
//	@Qualifier("car")
	@Qualifier("bus")
	private Vehicle vehicle;
	
	@Autowired
	private List<String> places;
	
	public void startTravel() {
		vehicle.run();
		System.out.println("Travel is begin... with first place " + places.get(0));
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Travel : " + name );
	}
}
