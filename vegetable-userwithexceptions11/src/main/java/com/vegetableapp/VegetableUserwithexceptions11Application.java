package com.vegetableapp;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.vegetableapp")
public class VegetableUserwithexceptions11Application {
	private static final Logger Log=LoggerFactory.getLogger(VegetableUserwithexceptions11Application.class);

	public static void main(String[] args) {
		Log.info("Starting application");
		SpringApplication.run(VegetableUserwithexceptions11Application.class, args);
		Log.info("VegetableUserwithexceptions11Application");
	}

}
