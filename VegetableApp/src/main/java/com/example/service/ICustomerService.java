package com.example.service;


import java.util.List;
import java.util.Optional;

import com.example.entity.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);

	public String removeCustomerById(int customerId);
	
    public Customer findCustomerById(int customerId);
    
    public List<Customer> getAllCustomers();
	
    public Optional<Customer> findCustomerById1(int customerId);

}
