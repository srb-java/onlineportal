package com.onlineportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class OnlineportalApplication {

	public static void main(String[] args) {
		System.out.println("Studentportal App RUnning!");
		SpringApplication.run(OnlineportalApplication.class, args);
	}

}
