package com.emyang.bootpjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootpjtApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BootpjtApplication.class, args);
		
		SpringApplication application = new SpringApplication(BootpjtApplication.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
//		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
