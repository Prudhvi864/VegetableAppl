package com.vegitables.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_details")
public class Admin {

	@Id
	@Column(name = "admin_Id")
	private int adminId;
	@Column(name = "admin_name")
	private String name;
	@Column(name = "admin_number")
	private long contactNumber;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "password")
	private String password;

	public Admin() {
		super();
	}

	public Admin(int adminId, String name, long contactNumber, String emailId, String password) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
