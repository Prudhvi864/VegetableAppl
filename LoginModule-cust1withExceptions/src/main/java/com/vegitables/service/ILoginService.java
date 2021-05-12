package com.vegitables.service;

import java.util.List;

import com.vegitables.entities.Customer;
import com.vegitables.entities.User;


public interface ILoginService {

	//public String validateLoginCustomer(Customer cust);
	//public String validateLoginAdmin(Admin admin);
	public String validateLoginCustomer(User user);
	public String validateLoginAdmin(User user);
	//public User logout(User user);
}
