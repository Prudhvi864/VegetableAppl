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

	@Test
	void testAddCustomershouldThrowDuplicateCustomerFoundExceptino() throws DuplicateCustomerFoundException {

		assertThrows(DuplicateCustomerFoundException.class, () -> {

			Address address = new Address();
			address.setAddressId(3);
			address.setFlatNo("9");
			address.setBuildingName("abc");
			address.setArea("nerul");
			address.setCity("qwe");
			address.setState("mh");
			address.setPincode("400706");

			Customer customer = new Customer();
			customer.setCustomerId(3);
			customer.setName("name");
			customer.setAddress(address);
			customer.setMobileNumber("7890");
			customer.setEmailId("d@gmail");
			customer.setPassword(null);
			service.addCustomer(customer);
		});
	}

	@Test
	void testForRemoveCustomerByIdshouldThrowCustomerNotFoundException() throws CustomerNotFoundException {

		assertThrows(CustomerNotFoundException.class, () -> {
			service.removeCustomerById(5);
		});
	}


}