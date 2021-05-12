package com.vegetableapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetableapp.entity.Customer;
import com.vegetableapp.entity.Feedback;
import com.vegetableapp.exception.DuplicateFeedbackIdFoundException;
import com.vegetableapp.exception.FeedbackNotFoundException;
import com.vegetableapp.exception.InvalidFeedbackFoundException;
import com.vegetableapp.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	FeedbackRepository Repo;

	// Adding Feedback Service Implementation

	@Override
	public Feedback addFeedback(Feedback feed) {
		// TODO Auto-generated method stub
		return Repo.save(feed);
	}

	// View all Feedbacks by vegetableId Service Implementation

	@Override
	public List<Feedback> viewAllFeedbacks(int vegetableId) {
		List<Feedback> viewfeed = Repo.viewAllFeedbacks(vegetableId);
		return viewfeed;
	}

	// View all Feedbacks by customerId Service Implementation

	@Override
	public List<Feedback> viewFeedback(int customerId) {
		return Repo.viewFeedback(customerId);
	}

	// Searching Feedback Service Implementation

	public Optional<Feedback> findByFeedbackId(int feedbackId) {
		return Repo.findById(feedbackId);

	}

	// Searching Ratings List Service Implementation

	@Override
	public List<Feedback> viewRating(int rating) {
		// TODO Auto-generated method stub
		List<Feedback> rate = Repo.viewRating(rating);
		return rate;

	}

	/***************************** Testing *********************************/

	@Override
	public Feedback createFeedback(Feedback feed)
			throws DuplicateFeedbackIdFoundException, InvalidFeedbackFoundException {
		// TODO Auto-generated method stub
		Feedback feedtest = null;
		System.out.println("feedbackId:" + feed.getFeedbackId());
		Optional<Feedback> result = Repo.findById(feed.getFeedbackId());
		if (result.isPresent()) {
			System.out.println("Id already exists.");
			throw new DuplicateFeedbackIdFoundException("Feedback with " + feed.getFeedbackId() + " already Exist");
		} else if (feed.getFeedbackId() <= 0) {
			throw new InvalidFeedbackFoundException("Id entered is Invalid");
		} else {
			feedtest = Repo.save(feed);
		}
		return feedtest;
	}

	@Override
	public Optional<Feedback> readFeedId(Integer FeedbackId) throws DuplicateFeedbackIdFoundException {
		// TODO Auto-generated method stub
		Optional<Feedback> result = Repo.findById(FeedbackId);
		if (result != null) {
			throw new DuplicateFeedbackIdFoundException("Feedback Id Already Exists");
		}
		return result;
	}

}