package com.vegitables.Testings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vegitables.entities.Admin;
import com.vegitables.exceptions.AdminAlreadyExistsException;
import com.vegitables.exceptions.AdminNotFoundException;
import com.vegitables.exceptions.InValidDataFoundException;
import com.vegitables.service.IAdminService;

@SpringBootTest
public class AdminServiceImplExceptionTest {
	
	@Autowired
	private IAdminService service;
	
	@Test
	void TestingAdmin() throws AdminNotFoundException{
		assertThrows(AdminNotFoundException.class, ()->{
			Admin adm = new Admin(110, "Hari", 77995, "Hari@123", "Hari123");
				service.readAdmin(110);
			});
	}
	
	@Test
	void testDuplicateAdmin() throws AdminAlreadyExistsException,InValidDataFoundException{
		assertThrows(AdminAlreadyExistsException.class, ()->{
		Admin admin = new Admin(101, "Phani", 779908485, "Phani@123", "phani7438");
			service.createAdmin(admin);
		});
		
	}
	
	@Test
	void testInvalidAdmin() throws AdminAlreadyExistsException,InValidDataFoundException{
		assertThrows(InValidDataFoundException.class, ()->{
		Admin admin = new Admin(-12, "Ajay", 45874, "Ajay@123", "ajaysha");
			service.createAdmin(admin);
		});
		
	}
	

}
