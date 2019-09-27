package com.microservice.family.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MircroserviceFamilyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircroserviceFamilyApplication.class, args);
	}

}
