package com.example.demo;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Address;
import com.example.entity.Customer;
import com.example.exception.CustomerNotFoundException;
import com.example.exception.DuplicateCustomerFoundException;
import com.example.service.ICustomerService;

@SpringBootTest
class ExceptionsTest {
	@Autowired
	private ICustomerService service;

	
	/*
	 * 
	 * While testing we have to uncomment the methods which throws exception
	 * This test case is created to see if DuplicatCustomerFoundException are getting thrown or not
	 * 
	 */
	
	@Test
	void testAddCustomershouldThrowDuplicateCustomerFoundException() throws DuplicateCustomerFoundException {

		assertThrows(DuplicateCustomerFoundException.class, () -> {

			Address address = new Address();
			address.setAddressId(2);
			address.setFlatNo("9");
			address.setBuildingName("abc");
			address.setArea("nerul");
			address.setCity("qwe");
			address.setState("mh");
			address.setPincode("400706");

			Customer customer = new Customer();
			customer.setCustomerId(2);
			customer.setName("name");
			customer.setAddress(address);
			customer.setMobileNumber("7890");
			customer.setEmailId("d@gmail");
			customer.setPassword(null);
			service.addCustomer(customer);
		});
	}

	/*
	 * 
	 * While testing we have to uncomment the methods which throws exception
	 * This test case is created to see if CustomerNotFoundException are getting thrown or not
	 * 
	 */
	
	@Test
	void testForRemoveCustomerByIdshouldThrowCustomerNotFoundException() throws CustomerNotFoundException {

		assertThrows(CustomerNotFoundException.class, () -> {
			service.removeCustomerById(5);
		});
	}


}