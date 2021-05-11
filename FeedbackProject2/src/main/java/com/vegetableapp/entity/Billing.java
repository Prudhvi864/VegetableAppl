package com.vegetableapp.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "billing_details8")
public class Billing {
	@Id
	@Column(name = "billing_id")
	private int billingId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_no")
	private Order orderNo;
	@Column(name = "transaction_mode")
	private String transactionMode;
	@Column(name = "transaction_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date transactionDate;
	@Column(name = "transaction_status")
	private String transactionStatus;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address billingAddress;

	public Billing() {

	}

	public Billing(int billingId, Order orderNo, String transactionMode, Date transactionDate,
			String transactionStatus, Address billingAddress) {
		super();
		this.billingId = billingId;
		this.orderNo = orderNo;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
		this.billingAddress = billingAddress;
	}
	


	public int getBillingId() {
		return billingId;
	}

	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}

	public Order getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Order orderNo) {
		this.orderNo = orderNo;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public String toString() {
		return "Billing Details [Billing Id=" + billingId + ", Order No=" + orderNo + ", Transaction Mode="
				+ transactionMode + ",Transaction Date= " + transactionDate + ", Transaction status="
				+ transactionStatus + ", Billing Address= " + billingAddress + "]";
	}

}
