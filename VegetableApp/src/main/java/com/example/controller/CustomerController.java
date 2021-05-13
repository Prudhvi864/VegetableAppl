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

	
	 /**
	 * This method is used to add customer to the database.
	 * 
	 * @param customer This is the argument to addCustomer method
	 * @exception handle DuplicateCustomerFoundException On input customerId already exist.
	 * @return customer
	 * output when customer gets successfully added into database.
	 * 
	 * url= http://localhost:8089/Rest/Customer
	 */
	
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

	
	
	
	
	
	
	/**
	 * This method is used to remove customer from the database.
	 * 
	 * @param customerId This is the argument to removeCustomerById method
	 * @exception handle CustomerNotFoundException On input customerId is not found.
	 * @return customer.
	 * 
	 * url = http://localhost:8089/Rest/Customer/{customerId}
	 */	
	
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
			throw new CustomerNotFoundException("Customer with id " + id + " not found.");
		}
	}

	
	
	
	/**
	 * This method is used to get all customers from the database.
	 * 
	 * @param nothing
	 * @exception handle CustomerNotFoundException if list of customer is empty.
	 * @return list of customers.
	 * 
	 * url=http://localhost:8089/Rest/Customer
	 */
	
    /************************* Getting list of all the customers **********************/
	
	@GetMapping(produces = "application/json")
	public List<Customer> getAllCustomer() {
		List<Customer> result = customerService.getAllCustomers();
		if (result.isEmpty()) {
			throw new CustomerNotFoundException("You dont have any records in database.");
		}
		return result;
	}

	
	
	
	/**
	 * This method is used to get customer from the database.
	 * 
	 * @param customerId This is the argument to findCustomerById method.
	 * @exception handle CustomerNotFoundException On customer, customerId  is not present in the database.
	 * @return payment.
	 * 
	 * url = http://localhost:8089/Rest/Customer/{customerId}
	 */
	
	/************************** Finding customer by id ********************************/
	
	@GetMapping(path = "/{customerId}", produces = "application/json")
	public Customer findCustomerById(@PathVariable("customerId") int id) throws CustomerNotFoundException {
		try {
			Customer customer = customerService.findCustomerById(id);
			return customer;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer with id " + id + " not found.");
		}

	}
	
	/**
	 * This method is used to update payment to the database.
	 * 
	 * @param customerId This is first the argument to  updatePayment method.
	 * @param customer This is second the argument to addCustomer method
	 * @exception handle CustomerNotFoundException On customer id is not present in the database.
	 * @return customer.
	 * 
	 * url = http://localhost:8089/Rest/Customer/{customerId}
	 */
	
	
	/**************************** Update customer *************************************/

	@PutMapping(path = "/{customerId}", consumes = "application/json")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer)
            throws CustomerNotFoundException {
        Optional<Customer> cust = customerService.findCustomerById1(customerId);

        if (!cust.isPresent()) {
            throw new CustomerNotFoundException("Customer with id " + customerId + " not found.");
        } else {
        	customerService.updateCustomer(customer);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
 
}
