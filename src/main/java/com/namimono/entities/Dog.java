package com.namimono.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class Dog implements ApplicationContextAware {
	
	//@Autowired
	private ApplicationContext applicationContext;

	public Dog(){
		System.out.println("dog constructor...");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Dog....@PostConstruct...");
	}
	
	@PreDestroy
	public void detory(){
		System.out.println("Dog....@PreDestroy...");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
		String [] beansName=applicationContext.getBeanDefinitionNames();
		for (String name:beansName)
		System.out.println(name);
	}




}