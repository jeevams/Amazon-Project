package com.example.amazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
public class AmazonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonApplication.class, args);
		System.out.println("amazon");
	}

}
