package com.example.SellService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SellServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellServiceApplication.class, args);
	}

}
