package com.vegitables.ctrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegitables.entities.User;
import com.vegitables.service.ILoginService;


@RestController
@RequestMapping(path="rest/login")
public class LoginController {
	@Autowired
	private ILoginService service;
	
	@PostMapping(path="/customer",consumes="application/json")		
	public ResponseEntity<?>  validateUser(@RequestBody User user){
		String result=service.validateLoginCustomer(user);
		 return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	@PostMapping(path="/admin",consumes="application/json")		
	public ResponseEntity<?>  validateUserByAdmin(@RequestBody User user){
		String result=service.validateLoginAdmin(user);
		 return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
}
