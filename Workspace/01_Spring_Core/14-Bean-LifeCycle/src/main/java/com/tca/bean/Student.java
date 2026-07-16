package com.tca.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Student implements BeanNameAware, 
	ApplicationContextAware, 
	InitializingBean, 
	DisposableBean {

	private String name;
	
	public Student() {
		System.out.println("Student object is created !");
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("Setter injection !!");
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean's destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean's afterPropertiesSet()");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware's setApplicationContext()");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware's setBeanName()");
	}
	
	
	public void myInit() {
		System.out.println("My custom initializing method : myInit()");
	}
	
	
	public void myDestroy() {
		System.out.println("My Custom desposing method : myDestroy()");
	}
	
}
