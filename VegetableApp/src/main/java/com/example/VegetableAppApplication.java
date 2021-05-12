package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.example")
@SpringBootApplication

public class VegetableAppApplication {

	private static final Logger log=LoggerFactory.getLogger(VegetableAppApplication.class);
	
	public static void main(String[] args) {
		log.info("Application Starting");
		SpringApplication.run(VegetableAppApplication.class, args);
		log.info("Application has started");	}

}
