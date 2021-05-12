package com.vegitables.service;

import java.util.List;
import java.util.Optional;

import com.vegitables.entities.Admin;

public interface IAdminService {
	public Admin addAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Optional<Admin> findAdmin(int adminid);
	public List<Admin> viewAllAdmins();
	public String removeAdmin(Optional<Admin> admin);
	
	/* 
	 * Methods for Testing Class
	 * 
	 */
	
	public Admin createAdmin(Admin admin);
	public Optional<Admin> readAdmin(int adminId);
	
}
