package com.vegetableapp.service;


import java.util.List;
import java.util.Optional;

import com.vegetableapp.entity.Customer;
import com.vegetableapp.entity.Feedback;

public interface FeedbackService {
	public Feedback addFeedback(Feedback feed);
	public List<Feedback> viewAllFeedbacks(int vegetableId);
	public List<Feedback> viewFeedback(int customerId);
	public Optional<Feedback> findByFeedbackId(int feedbackId);
	public Optional<Feedback> findByCustomerId(int customerId);

}
