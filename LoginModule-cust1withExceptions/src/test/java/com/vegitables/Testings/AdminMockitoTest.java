package com.vegitables.Testings;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.vegitables.entities.Admin;
import com.vegitables.repository.IAdminRepository;
import com.vegitables.service.IAdminServiceImpl;

@SpringBootTest
public class AdminMockitoTest {
	@Mock
	IAdminRepository adminRepo;

	@InjectMocks
	IAdminServiceImpl service;

	/*
	 * Method Name - addAdminTest, Parameter List - No parameter,
	 * Return type - Validation, Description - Testing the addAdmin method. .
	 */
	@Test
	public void addAdminTest() {
		Admin admin = new Admin(101, "Phani", 7799084, "Phani@123", "phani7438");
		service.addAdmin(admin);
		verify(adminRepo, times(1)).save(admin);
	}

	/*
	 * Method Name - updateAdminTest, Parameter List - No parameter,
	 * Return type - Validation, Description - Testing the updateAdmin method. .
	 */
	@Test
	public void updateAdminTest() {
		Admin admin = new Admin(101, "Phani", 7799084, "Phani@123", "phani7438");
		service.updateAdmin(admin);
		verify(adminRepo, times(1)).saveAndFlush(admin);
	}

	/*
	 * Method Name - deleteAdminTest, Parameter List - No parameter,
	 * Return type - Validation, Description - Testing deleteAdmin method. .
	 */
	/*@Test
	public void deleteAdminTest() {
		Admin admin = new Admin(101, "Phani", 7799084, "Phani@123", "phani7438");
		Optional<Admin> add = service.findAdmin(101);
		service.removeAdmin(add);
		verify(adminRepo, times(1)).deleteById(admin.getAdminId());
	}*/

}
