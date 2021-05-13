package com.vegetableapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication                             //To enable Host features
@ComponentScan(basePackages="com.vegetableapp")    //To locate and register all the  components 
public class FeedbackProjectApplication {
	private static final Logger log=LoggerFactory.getLogger(FeedbackProjectApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FeedbackProjectApplication.class, args);
		log.info("Running.....");
	}

}
