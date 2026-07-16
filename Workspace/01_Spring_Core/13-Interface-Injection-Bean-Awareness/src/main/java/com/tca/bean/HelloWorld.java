package com.tca.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloWorld implements BeanNameAware, ApplicationContextAware{

	private String beanName;
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("Application context injected.");
		this.applicationContext = applicationContext;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("I got my name !!!!");
		this.beanName = name;
	}
	
	public String getBeanName() {
		return beanName;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public void showAwarenessInfo() {
		System.out.println("My Name : " + beanName);
		System.out.println("ApplicationContext : " + applicationContext.getClass().getName());
	}

}
