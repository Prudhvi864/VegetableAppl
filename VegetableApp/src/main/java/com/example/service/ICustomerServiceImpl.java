package com.example.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

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

	@Override
    public Optional<Customer> findCustomerById1(int customerId) {
        // TODO Auto-generated method stub
        Optional<Customer> customer=customerRepository.findById(customerId);
        return customer;
    }
	

}
