package com.vegitables.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegitables.entities.Customer;
import com.vegitables.repository.IcustomerRepository;
@Service
public class IcustomerServiceImpl implements IcustomerService{
     @Autowired
     IcustomerRepository customerRepository;
	
     
 	@Override
 	public Customer addCustomer(Customer customer) {
 		customerRepository.save(customer);
 		return customer;
 	}

 	@Override
 	public String removeCustomerById(int customerId) {
 		customerRepository.deleteById(customerId);
 		return "Record is deleted by Id.";
 	}

 	@Override
 	public Customer findCustomerById(int customerId) {
 		// TODO Auto-generated method stub
 		Optional<Customer> cust = customerRepository.findById(customerId);
 		return cust.get();
 	}

 	@Override
 	public List<Customer> getAllCustomers(){
 		return customerRepository.findAll();
 	}

 	
	

}
