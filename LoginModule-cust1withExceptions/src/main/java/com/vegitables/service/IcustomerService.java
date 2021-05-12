package com.vegitables.service;

import java.util.List;

import com.vegitables.entities.Customer;

public interface IcustomerService {
	
	public Customer addCustomer(Customer customer);

    public String removeCustomerById(int customerId);
    
    public Customer findCustomerById(int customerId);
    
    public List<Customer> getAllCustomers();


}
