package com.vegitables.ctrl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegitables.entities.Admin;
import com.vegitables.entities.User;
import com.vegitables.exceptions.AdminNotFoundException;
import com.vegitables.exceptions.UserAlreadyExistsException;
import com.vegitables.exceptions.UserNotFoundException;
import com.vegitables.service.IUserService;

@RestController
@RequestMapping(path = "rest/users")
public class UserController {
	@Autowired
	IUserService service;

	@PostMapping(path = "/User", consumes = "application/json",produces = "application/json")
	public ResponseEntity<String> addUser(@RequestBody User user) throws UserAlreadyExistsException{
		String result = null;
		Optional<User> use = service.findByUserId(user);
		if (use.isPresent()) {
			throw new UserAlreadyExistsException("User with id " + user.getUserId() + " is already present.");
		} else {
			result = service.signInUser(user);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json",produces = "application/json")
	public ResponseEntity<String> addUserByrole(@RequestBody User user){
	      String result = null;
		result = service.signInUser(user);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete/{adminId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("adminId") String adminId,@RequestBody User user) throws UserNotFoundException {
		Optional<User> use = service.findByUserId(user);
		if (use.isEmpty()) {
			throw new UserNotFoundException("No User is present with id " + user.getUserId());
		}
		String msg = service.signOutUser(user);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
