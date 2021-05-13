package com.example.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.exception.CustomerNotFoundException;
import com.example.exception.DuplicateCustomerFoundException;
import com.example.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService {

	private static final Logger log = LoggerFactory.getLogger(ICustomerServiceImpl.class);

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Optional<Customer> removeCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepository.findById(customerId);
		customerRepository.deleteById(customerId);
		return customer;
	}

	@Override
	public Customer findCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> cust = customerRepository.findById(customerId);
		return cust.get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findCustomerById1(int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepository.findById(customerId);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return (Customer) customerRepository.saveAndFlush(customer);
	}

	/***************** Use it only for testing purpose******************8 */

//	@Override
//	public Customer addCustomer(Customer customer) throws DuplicateCustomerFoundException{
//		// TODO Auto-generated method stub
//		Optional<Customer> customer1=customerRepository.findById(customer.getCustomerId());
//		if(customer1.isPresent())
//		{
//			log.info("Duplicate customer found");
//			throw new DuplicateCustomerFoundException();
//		}
//		else
//		{
//			customerRepository.save(customer);
//		}
////		customerRepository.save(customer);
//		return customer;
//	}
//
//	@Override
//	public Optional<Customer> removeCustomerById(int customerId) throws CustomerNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<Customer> customer1=customerRepository.findById(customerId);
//		if(customer1.isEmpty())
//		{
//			log.info("Customer not found");
//			throw new CustomerNotFoundException();
//		}
//		else
//		{
//			customerRepository.deleteById(customerId);
//		}
////		customerRepository.save(customer);
//		return customer1;
//	}

}
