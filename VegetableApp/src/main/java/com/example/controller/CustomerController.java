package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer;
import com.example.exception.CustomerNotFoundException;
import com.example.exception.DuplicateCustomerFoundException;
import com.example.service.ICustomerService;

@RestController
@CrossOrigin
@RequestMapping(path = "/rest")

public class CustomerController {

	@Autowired
	ICustomerService customerService;

//	@PostMapping(consumes = "application/json", produces = "application/json")
//	public Customer addCustomer(@RequestBody Customer customer) {
//
//		Customer cust = customerService.findCustomerById(customer.getCustomerId());
//
//		if (!(cust == null)) {
//			throw new DuplicateCustomerFoundException("Duplicate customer is not allowed");
//
//		} else {
//			customerService.addCustomer(customer);
//
//		}
//		return customer;
//	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> addAdmin(@RequestBody Customer customer) throws DuplicateCustomerFoundException {
		Optional<Customer> a = customerService.findCustomerById1(customer.getCustomerId());
		if (a.isPresent()) {
			throw new DuplicateCustomerFoundException(
					"Customer with id " + customer.getCustomerId() + " alraedy exists.");
		} else {
			customerService.addCustomer(customer);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

//	@PostMapping(consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Customer> addAdmin(@RequestBody Customer admin) throws DuplicateCustomerFoundException {
//     Customer a=customerService.findCustomerById(admin.getCustomerId());
//     if(!(a == null)) {
//         throw new DuplicateCustomerFoundException("Admin  with id "+admin.getCustomerId()+" alraedy exists.");
//     }
//     else {
//    	 customerService.addCustomer(admin);
//     }
//        return new ResponseEntity<Customer>(admin,HttpStatus.OK);
//    }

	@DeleteMapping(path = "/{customerId}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("customerId") int id)
			throws CustomerNotFoundException {
		try {
			Customer result = customerService.findCustomerById(id);
			ResponseEntity<Customer> response = null;
			customerService.removeCustomerById(id);
			response = new ResponseEntity<Customer>(result, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
	}

//	@DeleteMapping(path = "/{customerId}")
//	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("customerId") int id) {
//			Customer result = customerService.findCustomerById(id);
//	if((result == null))
//	{
//		throw new CustomerNotFoundException("Customer Not Found");
//	}
//			ResponseEntity<Customer> response = null;
//			customerService.removeCustomerById(id);
//			response = new ResponseEntity<Customer>(result, HttpStatus.OK);
//			return response;
//	}

	@GetMapping(produces = "application/json")
	public List<Customer> getAllCustomer() {
		List<Customer> result = customerService.getAllCustomers();
		if (result.isEmpty()) {
			throw new CustomerNotFoundException("No customer is present in the list");
		}
		return result;
	}

	@GetMapping(path = "/{customerId}", produces = "application/json")
	public Customer findCustomerById(@PathVariable("customerId") int id) throws CustomerNotFoundException {
		try {
			Customer customer = customerService.findCustomerById(id);
			return customer;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found");
		}

	}

}
