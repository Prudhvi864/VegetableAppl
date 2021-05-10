package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.example")
@SpringBootApplication

public class VegetableAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VegetableAppApplication.class, args);
		System.out.println("Its working");
	}

}
