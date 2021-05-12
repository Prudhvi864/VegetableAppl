package com.example.service;


import java.util.List;
import java.util.Optional;

import com.example.entity.Customer;
import com.example.exception.CustomerNotFoundException;
import com.example.exception.DuplicateCustomerFoundException;

public interface ICustomerService {
	
//	public Customer addCustomer(Customer customer);
//	
//	public Optional<Customer> removeCustomerById(int customerId);
	
    public Customer findCustomerById(int customerId);
    
    public List<Customer> getAllCustomers();
	
    public Optional<Customer> findCustomerById1(int customerId);
    
    public Customer updateCustomer(Customer customer);

	/***************  Use it only for testing **************/
	public Customer addCustomer(Customer customer) throws DuplicateCustomerFoundException;

	public Optional<Customer> removeCustomerById(int customerId) throws CustomerNotFoundException;

}
