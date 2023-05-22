package com.example.Email2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Email2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Email2Application.class, args);
	}
	
}
