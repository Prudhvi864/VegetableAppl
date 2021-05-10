package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@RequestMapping(value="/hello")
	public String sayHello() {
	System.out.println("hello........");
	return "Hello Cg! from Spring Framework!";
	}

}