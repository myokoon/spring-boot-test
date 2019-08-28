package com.emyang.bootpjt.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.emyang.bootpjt.property.EmyangProperties;

@Component
public class MyRunner implements ApplicationRunner {
	
	@Value("${emyang.name}")
	private String name;
	
	@Value("${emyang.age}")
	private int age;
	
	@Autowired
	EmyangProperties property;
	
	@Autowired
	String hello;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Program 아규먼트 - " + args.containsOption("bar"));
		System.out.println("VM 아규먼트 - " + args.containsOption("foo"));
		
		logger.debug("Property Name : " + name);
		logger.debug("Property Age : " + age);
		logger.debug("Property Class Name : " + property.getFullName());
		logger.debug("현재 적용된 Profile : " + hello);
	}
	
}
