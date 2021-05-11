package com.vegetableapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetableapp.entity.Customer;
import com.vegetableapp.entity.Feedback;
import com.vegetableapp.exception.FeedbackNotFoundException;
import com.vegetableapp.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	FeedbackRepository Repo;

	@Override
	public Feedback addFeedback(Feedback feed) {
		// TODO Auto-generated method stub
		return Repo.save(feed);
	}

	@Override
	public List<Feedback> viewAllFeedbacks(int vegetableId) {
		List<Feedback> viewfeed = Repo.viewAllFeedbacks(vegetableId);
		return viewfeed;
	}

	@Override
	public List<Feedback> viewFeedback(int customerId) {
		return Repo.viewFeedback(customerId);
	}

	@Override
	public Optional<Feedback> findByFeedbackId(int feedbackId) {
		return Repo.findById(feedbackId);

	}

	@Override
	public Optional<Feedback> findByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return Repo.findById(customerId);
	}

}