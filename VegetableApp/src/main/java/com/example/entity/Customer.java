package com.example.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_details")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "mobile_number")
    private String mobileNumber;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    private Address address;
    
    @Column(name = "email_id")
    private String emailId;
    
    @Column(name = "password")
    private String password;
    
    
    public Customer() {
    
    }

    
    public Customer(int customerId, String name, String mobileNumber, Address address, String emailId,
            String password) {
        super();
        this.customerId = customerId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.emailId = emailId;
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

 

    public Address getAddress() {
        return address;
    }

 

    public void setAddress(Address address) {
        this.address = address;
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

 

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
                + address + ", emailId=" + emailId + ", password=" + password + "]";
    }
}