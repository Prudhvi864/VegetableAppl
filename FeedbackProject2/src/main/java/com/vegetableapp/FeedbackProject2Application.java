package com.vegetableapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.vegetableapp")
public class FeedbackProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackProject2Application.class, args);
		System.out.println("Running.....");
	}

}