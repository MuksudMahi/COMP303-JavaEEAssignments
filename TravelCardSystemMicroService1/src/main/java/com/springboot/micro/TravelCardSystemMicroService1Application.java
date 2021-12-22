package com.springboot.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  
public class TravelCardSystemMicroService1Application {

	public static void main(String[] args) {
		SpringApplication.run(TravelCardSystemMicroService1Application.class, args);
	}

}
