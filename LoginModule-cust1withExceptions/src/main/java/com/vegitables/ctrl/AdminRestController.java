package com.vegitables.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegitables.entities.Admin;
import com.vegitables.entities.Customer;
import com.vegitables.exceptions.AdminAlreadyExistsException;
import com.vegitables.exceptions.AdminNotFoundException;
import com.vegitables.service.IAdminService;

@RestController
@RequestMapping(path = "rest/admin")
public class AdminRestController {
	@Autowired
	private IAdminService service;

	/*
	 * Functionality Name - POST, Parameters - Admin object,
	 * Return type - ResponseEntity<Admin> , Description - Adding new Admin by checking Exceptions.
	 */
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws AdminAlreadyExistsException {
		Optional<Admin> a = service.findAdmin(admin.getAdminId());
		if (a.isPresent()) {
			throw new AdminAlreadyExistsException("Admin  with id " + admin.getAdminId() + " alraedy exists.");
		} else {
			service.addAdmin(admin);
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	/*
	 * Functionality Name - PUT, Parameters - Admin object,
	 * Return type - ResponseEntity<Admin> , Description - Updating existing Admin by checking Exceptions.
	 */
	@PutMapping(path = "/update/{adminId}", consumes = "application/json")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("adminId") int adminId, @RequestBody Admin admin)
			throws AdminNotFoundException {
		Optional<Admin> ad = service.findAdmin(adminId);
		if (!ad.isPresent()) {
			throw new AdminNotFoundException("No admin is present with id " + adminId + " to Update");
		} else {
			service.updateAdmin(admin);
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	/*
	 * Functionality Name - DELETE, Parameters - int adminId,
	 * Return type - ResponseEntity<String> , Description - Deleting existing Admin by checking Exceptions.
	 */
	@DeleteMapping(path = "/delete/{adminId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("adminId") int adminId)
			throws AdminNotFoundException {
		Optional<Admin> admin = service.findAdmin(adminId);
		if (!admin.isPresent()) {
			throw new AdminNotFoundException("No admin is present with id " + adminId);
		}
		String msg = service.removeAdmin(admin);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	/*
	 * Functionality Name - GET, Parameters - No Parameter,
	 * Return type - ResponseEntity<List<Admin>> , Description - Listing all existing Admins by checking Exceptions.
	 */
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Admin>> getAllAdmins() throws AdminNotFoundException {
		List<Admin> result = service.viewAllAdmins();
		if (result.isEmpty()) {
			throw new AdminNotFoundException("There are no admins to display.");
		}
		return new ResponseEntity<List<Admin>>(result, HttpStatus.OK);
	}

}
