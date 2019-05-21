package com.namimono.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Dog implements ApplicationContextAware, BeanNameAware {
	
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


	public void setBeanName(String name) {
		System.out.println("获取到bean的名字为："+name);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("获取的IOC容器为："+applicationContext);
		this.applicationContext=applicationContext;
	}
}
