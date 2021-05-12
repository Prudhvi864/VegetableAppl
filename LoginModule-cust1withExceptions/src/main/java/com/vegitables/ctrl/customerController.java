package com.vegitables.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegitables.entities.Customer;
import com.vegitables.service.IcustomerService;

@RestController
@RequestMapping(path="rest/customer")
public class customerController {

	@Autowired
    IcustomerService customerService;

 

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.ok(customer);
    }

 

    @DeleteMapping(path = "/{customerId}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable("customerId") int id) {
        Customer result = customerService.findCustomerById(id);
        ResponseEntity<Customer> response = null;

 

        if (result != null) {
            if (result.getCustomerId() > 0) {
                customerService.removeCustomerById(id);
                response = new ResponseEntity<Customer>(result, HttpStatus.OK);
            }
        }
        return response;
    }
    
    @GetMapping(produces = "application/json")
    public List<Customer> getAllCustomer() {
        List<Customer> result = customerService.getAllCustomers();
        return result;
    }
    
    @GetMapping(path = "/{customerId}",produces = "application/json")
    public Customer getCustomerById(@PathVariable("customerId") int id) {
        Customer customer = customerService.findCustomerById(id);
        return customer;
    }
	
}
