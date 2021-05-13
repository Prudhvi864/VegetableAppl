package com.vegetableapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 								 // It specifies that the class is an entity and is mapped to a database table.
@Table(name = "feedback_details11")		 // Mapping with Customer Table in SQL
public class Feedback {

	@Id // primary key of current entity
	@Column(name = "feedback_id")
	private int feedbackId;
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "customer_id") // Joining customer table using customer Id
	private Customer customerId;
	/*
	 * @Column(name="customer_id") private int customerId;
	 */
	@Column(name = "vegetable_id")
	private int vegetableId;
	@Column(name = "rating")
	private int rating;
	@Column(name = "comments")
	private String comments;

	public Feedback() {

	}
	/*
	 * public Feedback(int feedbackId, int customerId, int vegetableId, int rating,
	 * String comments) { super(); this.feedbackId = feedbackId; this.customerId =
	 * customerId; this.vegetableId = vegetableId; this.rating = rating;
	 * this.comments = comments; }
	 */

	public Feedback(int feedbackId, Customer customerId, int vegetableId, int rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.customerId = customerId;
		this.vegetableId = vegetableId; // Constructor
		this.rating = rating;
		this.comments = comments;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	/*
	 * public int getCustomerId() { return customerId; }
	 * 
	 * public void setCustomerId(int customerId) { this.customerId = customerId; }
	 */

	public int getVegetableId() {
		return vegetableId; // Getters and Setters
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

	// Generating Values

	@Override
	public String toString() {
		return "Feedback [feedback Id=" + feedbackId + ", customer Id=" + customerId + ", vegetable Id=" + vegetableId
				+ ", Rating=" + rating + ", comments=" + comments + "]";
	}

}
