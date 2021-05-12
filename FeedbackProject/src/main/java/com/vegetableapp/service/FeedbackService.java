package com.vegetableapp.service;

import java.util.List;
import java.util.Optional;

import com.vegetableapp.entity.Customer;
import com.vegetableapp.entity.Feedback;
import com.vegetableapp.exception.DuplicateFeedbackIdFoundException;
import com.vegetableapp.exception.FeedbackNotFoundException;
import com.vegetableapp.exception.InvalidFeedbackFoundException;

public interface FeedbackService {
	public Feedback addFeedback(Feedback feed);

	public List<Feedback> viewAllFeedbacks(int vegetableId);

	public List<Feedback> viewFeedback(int customerId);

	public List<Feedback> viewRating(int rating);

	public Optional<Feedback> findByFeedbackId(int feedbackId);

	public Feedback createFeedback(Feedback feed)
			throws DuplicateFeedbackIdFoundException, InvalidFeedbackFoundException;

	public Optional<Feedback> readFeedId(Integer FeedbackId) throws FeedbackNotFoundException;

}
