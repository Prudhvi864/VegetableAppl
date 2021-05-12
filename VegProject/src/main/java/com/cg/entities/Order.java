package com.cg.entities;

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

@Entity
@Table(name = "order_details3")  //Mapping with sql table.

public class Order {
	
	/*@Id
	@Column(name = "order_no")
	private int orderNo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "veg_id")
	private VegetableDTO vegetabledto;
	
	@Column(name = "total_amount")
	private double totalAmount;
	@Column(name = "order_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//@Temporal(TemporalType.DATE)
    private Date Date;
	@Column(name = "status")
	private String status;


	public Order(int orderNo, Customer customerId, VegetableDTO vegetabledto, double totalAmount, java.util.Date date,
			String status) {
		super();
		this.orderNo = orderNo;
		this.customerId = customerId;
		this.vegetabledto = vegetabledto;          //constructor
		this.totalAmount = totalAmount;
		Date = date;
		this.status = status;
	}

	

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	                                            //getters & setters for Order. 
	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public VegetableDTO getVegetabledto() {
		return vegetabledto;
	}

	public void setVegetabledto(VegetableDTO vegetabledto) {
		this.vegetabledto = vegetabledto;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", customerId=" + customerId + ", vegetabledto=" + vegetabledto
				+ ", totalAmount=" + totalAmount + ", Date=" + Date + ", status=" + status + "]";
	}
*/
		
	
	
	
	
		
	
	
	
	
	
	@Id
	@Column(name = "order_no")
	private int orderNo;

	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "veg_id")
	private int vegId;
	
	@Column(name = "total_amount")
	private double totalAmount;
	@Column(name = "order_date")

	private String date;
	@Column(name = "status")
	private String status;

	public Order() {

	}

	public Order(int orderNo, int customerId, int vegId, double totalAmount, String date, String status) {
		super();
		this.orderNo = orderNo;
		this.customerId = customerId;
		this.vegId = vegId;
		this.totalAmount = totalAmount;
		this.date = date;
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

	public int getVegId() {
		return vegId;
	}

	public void setVegId(int vegId) {
		this.vegId = vegId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", customerId=" + customerId + ", vegId=" + vegId + ", totalAmount="
				+ totalAmount + ", date=" + date + ", status=" + status + "]";
	}

}
