package com.vegitables.service;

import java.util.Optional;

import com.vegitables.entities.User;

public interface IUserService {

	public String signInUser(User user);

	public String signOutUser(User user);

	public Optional<User> findByUserId(User user);

}
