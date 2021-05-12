package com.vegetableapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                              //It specifies that the class is an entity and is mapped to a database table.
@Table(name = "address_details8")    //Mapping with Address Table in SQL
public class Address {
	@Id                              //primary key of current entity
	@Column(name = "address_id")
	private int addressId;
	@Column(name = "flat_no")
	private String flatNo;
	@Column(name = "building_name")
	private String buildingName;
	@Column(name = "area")
	private String area;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private String pincode;

	public Address() {
		super();
	}

	public Address(int addressId, String flatNo, String buildingName, String area, String city, String state,
			String pincode) {
		super();
		this.addressId = addressId;
		this.flatNo = flatNo;
		this.buildingName = buildingName;
		this.area = area;                          //Constructor
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFloatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;                    //Getters and Setters
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override                                          //Generating Values
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNo=" + flatNo + ", buildingName=" + buildingName + ", area="
				+ area + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

}