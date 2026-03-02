package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class NotificationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationSystemApplication.class, args);
		ConfigurableApplicationContext context =
				SpringApplication.run(NotificationSystemApplication.class, args);
		
				Notification email = (Notification) context.getBean("emailBean");
				email.send("Hello via Email!");
				
				
				Notification sms = (Notification) context.getBean("smsBean");
				sms.send("Hello via SMS!");
				
				context.close();
	}

}
