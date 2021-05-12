package com.vegetableapp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity                               //It specifies that the class is an entity and is mapped to a database table.
@Table(name = "order_details8")       //Mapping with Order Table in SQL

public class Order {
	@Id                               //primary key of current entity
	@Column(name = "order_no")
	private int orderNo;
	@Column(name = "customer_id")
	private int customerId;

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "veg_id")
	//private List<VegetableDTO> vegetableList;

	@Column(name = "total_amount")
	private double totalAmount;
	@Column(name = "order_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//@Temporal(TemporalType.DATE)
    private Date Date;
	@Column(name = "status")
	private String status;

	public Order() {

	}

	public Order(int orderNo, int customerId, double totalAmount, Date orderDate, String status) {
		super();
		this.orderNo = orderNo;
		this.customerId = customerId;
		this.totalAmount = totalAmount;                      //Constructor
		this.Date = orderDate;
		this.status = status;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
																//Getters and Setters
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return Date;
	}

	public void setOrderDate(Date orderDate) {
		this.Date = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override                                                    //Generating Values
	public String toString() {
		return "Order [orderNo=" + orderNo + ", customerId=" + customerId + ", totalAmount=" + totalAmount + ", orderDate="
				+ Date + ", status=" + status + "]";
	}

	
}

