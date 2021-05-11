package com.vegetableapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="customer_details11")
public class Customer {
	@Id
    @Column(name="customer_id")
	private int customerId;
	@Column(name = "customer_name")
	private String name;
	@Column(name = "mobile_number")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String mobileNumber;
    @Column(name="address_id")
    @JsonProperty(access = Access.WRITE_ONLY)
	private int addressId;
    @Column(name="user_id")
    @JsonProperty(access = Access.WRITE_ONLY)
	private String userId;
	@Column(name = "password")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	public Customer() {
	
	}

	public Customer(int customerId, String name, String mobileNumber, int addressId, String userId,
			String password) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.addressId = addressId;
		this.userId = userId;
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
				+ addressId + ", User Id=" + userId + ", password=" + password + "]";
	}
	
	
	

}
