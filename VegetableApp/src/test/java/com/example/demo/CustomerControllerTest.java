package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Address;
import com.example.entity.Customer;
import com.example.repository.ICustomerRepository;

import com.example.service.ICustomerServiceImpl;


@SpringBootTest
public class CustomerControllerTest {

	@Mock
	ICustomerRepository customerRepository;

	@InjectMocks
	ICustomerServiceImpl service;

	/* Test Case For Add Customer */

	@Test
	public void addCustomerTest() {

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

		verify(customerRepository, times(1)).save(customer);

	}
	
	
	/* Test Case For Remove Customer */
	
	@Test
	public void removeCustomerTest() {
		
		Address address = new Address();
		address.setAddressId(1);
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

		Optional<Customer> customer1 = service.removeCustomerById(2);
		Assertions.assertThat(customer1).isNotNull();
		verify(customerRepository, times(1)).deleteById(customer.getCustomerId());
	}
	
	/* Test case for get Customer Details by Id */

	@Test
	public void getCustomerByIdTest() {

		Address address = new Address();
		address.setAddressId(1);
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


		final Customer expected = service.findCustomerById(customer.getCustomerId());
		Assertions.assertThat(expected).isNotNull();
	}
	
	
	/* Test Case For Get Customer Details For Null Id */
	@Test
	public void getCustomerNullTest() {
		int id = 0;
		Customer actual = service.findCustomerById(id);
		assertNull(actual);
	}

	/* Test case for get all Customer Details */
	@Test
	public void getAllCustomerTest() {
        
		Address address = new Address();
		address.setAddressId(1);
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

		Address address1 = new Address();
		address1.setAddressId(11);
		address1.setFlatNo("9");
		address1.setBuildingName("abc");
		address1.setArea("nerul");
		address1.setCity("qwe");
		address1.setState("mh");
		address1.setPincode("400706");

		Customer customer1 = new Customer();
		customer1.setCustomerId(3);
		customer1.setName("name");
		customer1.setAddress(address);
		customer1.setMobileNumber("7890");
		customer1.setEmailId("d@gmail");
		customer1.setPassword(null);

		List<Customer> list = new ArrayList<>();
		list.add(customer);
		list.add(customer1);
		
		Mockito.when(customerRepository.findAll()).thenReturn(list);
		List<Customer> actual = service.getAllCustomers();
		assertEquals(2, actual.size());
	}
}
