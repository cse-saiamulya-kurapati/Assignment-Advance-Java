package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PaymentspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentspringApplication.class, args);
		
		
		ApplicationContext context = SpringApplication.run(Payment.class, args);
	}

}

