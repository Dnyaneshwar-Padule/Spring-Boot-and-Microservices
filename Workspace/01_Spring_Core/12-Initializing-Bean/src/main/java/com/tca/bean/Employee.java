package com.tca.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean{

	private int id;
	private String name;
	private double salary;
	
	public Employee() {
		System.out.println("Employee.Employee()");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Employee.destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Employee.afterPropertiesSet()");
	}

}
