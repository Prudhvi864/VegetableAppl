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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer;
import com.example.exception.CustomerNotFoundException;
import com.example.exception.DuplicateCustomerFoundException;
import com.example.service.ICustomerService;

@RestController
@CrossOrigin
@RequestMapping(path = "/Customer")

public class CustomerController {

	@Autowired
	ICustomerService customerService;

	
	/******************************* Add customer  ******************************/
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws DuplicateCustomerFoundException {
		Optional<Customer> a = customerService.findCustomerById1(customer.getCustomerId());
		if (a.isPresent()) {
			throw new DuplicateCustomerFoundException(
					"Customer with id " + customer.getCustomerId() + " alraedy exists.");
		} else {
			customerService.addCustomer(customer);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	
	/******************************* Remove customer *********************************/
	
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

	
    /************************* Getting list of all the customers **********************/
	
	@GetMapping(produces = "application/json")
	public List<Customer> getAllCustomer() {
		List<Customer> result = customerService.getAllCustomers();
		if (result.isEmpty()) {
			throw new CustomerNotFoundException("No customer is present in the list");
		}
		return result;
	}

	
	/************************** Finding customer by id ********************************/
	
	@GetMapping(path = "/{customerId}", produces = "application/json")
	public Customer findCustomerById(@PathVariable("customerId") int id) throws CustomerNotFoundException {
		try {
			Customer customer = customerService.findCustomerById(id);
			return customer;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found");
		}

	}
	
	
	/**************************** Update customer *************************************/

	@PutMapping(path = "/{customerId}", consumes = "application/json")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer)
            throws CustomerNotFoundException {
        Optional<Customer> cust = customerService.findCustomerById1(customerId);

        if (!cust.isPresent()) {
            throw new CustomerNotFoundException("No customer is present with id " + customerId + " to Update");
        } else {
        	customerService.updateCustomer(customer);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
 
}
