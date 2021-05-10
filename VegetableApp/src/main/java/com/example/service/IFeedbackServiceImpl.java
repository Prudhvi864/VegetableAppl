package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Feedback;
import com.example.repository.IFeedbackRepository;

@Service
public class IFeedbackServiceImpl implements IFeedbackService{

	    @Autowired
	    IFeedbackRepository Repo;

	 

	    @Override
	    public Feedback addFeedback(Feedback feed) {
	        // TODO Auto-generated method stub
	        return Repo.save(feed);
	    }



//	    @Override
//	    public List<Feedback> viewAllFeedbacks(int vegetableId) {
//	        List<Feedback> viewfeed = Repo.viewAllFeedbacks(vegetableId);
//	        // TODO Auto-generated method stub
//	        return viewfeed;
//	    }

	 

	    @Override
	    public Optional<Feedback> viewFeedback(int customerId) {
	        Optional<Feedback> customerfeed = Repo.findById(customerId);
			return customerfeed;
	    }
	 
}
