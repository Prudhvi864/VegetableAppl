package com.vegitables.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegitables.entities.User;
import com.vegitables.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepo;
    
	/*
	 * Method Name - SignInUser, Parameter List - User object,
	 * Return type - String, Description - adding user to the database.
	 */
	@Override
	public String signInUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
		String msg=null;
		if(user.getRole().equalsIgnoreCase("Customer")) {
			msg="Signed in sucessfully...!!, Welcome Customer.";
		}
		else if(user.getRole().equalsIgnoreCase("Admin")) {
			msg="Signed in sucessfully...!!, Welcome Admin.";
		}
		return msg;
	}

	/*
	 * Method Name - SignOutUser, Parameter List - User object,
	 * Return type - String, Description - Deleting user from the database.
	 */
	@Override
	public String signOutUser(User user) {
		// TODO Auto-generated method stub
		userRepo.delete(user);
		return "User signed Out Sucessfully.";
	}

	/*
	 * Method Name - findById, Parameter List - User object,
	 * Return type - User object, Description - Finding user by using userId from the database.
	 */
	@Override
	public Optional<User> findByUserId(User user) {
		// TODO Auto-generated method stub
		Optional<User> use = userRepo.viewByUserId(user.getUserId());
		return use;
	}

}
