package com.example.service;


import java.util.Optional;

import com.example.entity.Feedback;

public interface IFeedbackService {

	public Feedback addFeedback(Feedback feed);

//	public List<Feedback> viewAllFeedbacks(int vegetableId);

	public Optional<Feedback> viewFeedback(int customerId);

}
