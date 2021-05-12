package com.vegitables.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vegitables.entities.Admin;
import com.vegitables.exceptions.AdminAlreadyExistsException;
import com.vegitables.exceptions.AdminNotFoundException;
import com.vegitables.exceptions.InValidDataFoundException;
import com.vegitables.repository.IAdminRepository;

@Service
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminRepo;

	/*
	 * Method Name - addAdmin, Parameter List - Admin object, Return type - Admin
	 * object, Description - insert a admin object into the database
	 */
	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return (Admin) adminRepo.save(admin);
	}

	/*
	 * Method Name - updateAdmin, Parameter List - Admin object, Return type - Admin
	 * object, Description - update the existing vales by new admin object into the
	 * database
	 */
	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return (Admin) adminRepo.saveAndFlush(admin);
	}

	/*
	 * Method Name - findAdmin, Parameter List - Admin object of integer type,
	 * Return type - Admin object, Description - find admin by the admin Id from the
	 * database
	 */
	@Override
	public Optional<Admin> findAdmin(int adminId) {
		// TODO Auto-generated method stub
		Optional<Admin> admin = adminRepo.findById(adminId);
		return admin;
	}

	/*
	 * Method Name - viewAllAdmin, Parameter List - No parameter, Return type - List
	 * of Admin object, Description - find all the admin . Present in the database
	 */
	@Override
	public List<Admin> viewAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	/*
	 * Method Name - removeAdmin, Parameter List - Admin object, Return type -
	 * String, Description - Deleting admin using the admin Id from the database.
	 */
	@Override
	public String removeAdmin(Optional<Admin> admin) {
		// TODO Auto-generated method stub
		adminRepo.deleteById(admin.get().getAdminId());
		return "Record With Given Id Is Deleted";
	}

	/************************* Methods For Testing *******************************/

	/*
	 * Method Name - createAdmin, Parameter List - Admin object, 
	 * Return type - Admin object, Description - creating new Admin and insert into the database and
	 * checking Exceptions.
	 */
	@Override
	@Transactional
	public Admin createAdmin(Admin admin) throws AdminAlreadyExistsException, InValidDataFoundException {
		// TODO Auto-generated method stub
		System.out.println("AdminId : " + admin.getAdminId());
		Optional<Admin> ad = adminRepo.findById(admin.getAdminId());
		Admin adm=null;
		if (ad.isPresent()) {
			System.out.println("Id already exists.");
				throw new AdminAlreadyExistsException("Admin with " + admin.getAdminId() + " already Exist");
		}
		else if (admin.getAdminId() <= 0) {
			throw new InValidDataFoundException("Id entered is Invalid");
		}
		else {
		 adm=adminRepo.save(admin);
		}
		return adm;

	}

	/*
	 * Method Name - readAdmin, Parameter List - integer admin object, 
	 * Return type -String, Description - Deleting admin using the admin Id from the database.
	 */
	@Override
	public Optional<Admin> readAdmin(int adminId) throws AdminNotFoundException{
		// TODO Auto-generated method stub
		Optional<Admin> admin = adminRepo.findById(adminId);
		if(admin.isEmpty()) {
			throw new AdminNotFoundException("Admin with id is not present.");
		}
		return admin;
	}

}
