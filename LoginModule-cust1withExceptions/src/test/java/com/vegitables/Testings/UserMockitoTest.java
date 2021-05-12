package com.vegitables.Testings;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.vegitables.entities.User;
import com.vegitables.repository.IUserRepository;
import com.vegitables.service.IUserServiceImpl;

@SpringBootTest
public class UserMockitoTest {

	@Mock
	IUserRepository userRepo;

	@InjectMocks
	IUserServiceImpl service;

	/*
	 * Method Name - SignInUserTest, Parameter List - No parameter,
	 * Return type - Validation, Description - Testing the SignInUser method. .
	 */
	/*@Test
	public void SignInUserTest() {
		User user = new User("Phani@123", "phani7438", "Admin");
		service.signInUser(user);
		verify(userRepo, times(1)).save(user);
	}*/

	/*
	 * Method Name - SignOutUserTest, Parameter List - No parameter,
	 * Return type - Validation, Description - Testing the SignOutUser method. .
	 */
	@Test
	public void SignOutUserTest() {
		User user = new User("Phani@123", "phani7438", "Admin");
		service.signOutUser(user);
		verify(userRepo, times(1)).viewByUserId(user.getUserId());
	}
	/*@Test
    public void removeCustomerTest() {
		User user = new User("Phani@123", "phani7438", "Admin");
        //given(userRepo.viewByUserId(user.getUserId())).willReturn(Optional.of(user));
        Optional<User> use= userRepo.viewByUserId(user.getUserId());
        Assertions.assertThat(use).isNotNull();
        verify(userRepo, times(1)).d();
    }*/
/*       given(customerRepository.findById(customer.getCustomerId())).willReturn(Optional.of(customer));
	        Optional<Customer> customer1 = service.removeCustomerById(2);
	        Assertions.assertThat(customer1).isNotNull();
	        verify(customerRepository, times(1)).deleteById(customer.getCustomerId());
	    }*/

}
