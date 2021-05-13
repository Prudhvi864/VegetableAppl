package com.vegetableapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.vegetableapp")      //to locate and register all the  components 
public class FeedbackProject2Application {
	private static final Logger log1=LoggerFactory.getLogger(FeedbackProject2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(FeedbackProject2Application.class, args);
		log1.info("Running.....");
		
	}

}