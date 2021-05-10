package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback_details")
public class Feedback {
    @Id
    @Column(name = "feedback_id")
    private int feedbackId;
    
    @OneToOne(targetEntity = Customer.class,cascade=CascadeType.ALL)
    @JoinColumn(name="customer_id")  
    private Customer customer;
    
    @Column(name = "vegetable_id")
    private int vegetableId;
    
    @Column(name = "rating")
    private int rating;
    
    @Column(name = "comments")
    private String comments;
    
    public Feedback() {
    	
    }

	public Feedback(int feedbackId, Customer customer, int vegetableId, int rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.customer = customer;
		this.vegetableId = vegetableId;
		this.rating = rating;
		this.comments = comments;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getVegetableId() {
		return vegetableId;
	}

	public void setVegetableId(int vegetableId) {
		this.vegetableId = vegetableId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
