package com.vegetableapp.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetableapp.entity.Feedback;
import com.vegetableapp.exception.DuplicateFeedbackIdFoundException;
import com.vegetableapp.exception.FeedbackNotFoundException;
import com.vegetableapp.service.FeedbackService;

/*
 * Web Controller deals with HTTP requests and HTTP responses.
 * */

@RestController
@RequestMapping("rest/feedback")              // Mapping Path for Feedback Controller
public class FeedbackController {

	@Autowired
	private FeedbackService service;          // Importing FeedbackService and implementation

	
	  // Adding Feedback in postman using POST
	
	@PostMapping("/addfeedback")              
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feed) {
		Optional<Feedback> addobj1 = service.findByFeedbackId(feed.getFeedbackId());
		if (addobj1.isPresent()) {
			throw new DuplicateFeedbackIdFoundException("Duplicate Feedback Id Found, Already Exists");
		} else {
			service.addFeedback(feed);
		}
		return new ResponseEntity<Feedback>(feed, HttpStatus.OK);
	}
	
	  // Using GET Mapping fetching results from vegetable id
	
	@GetMapping("/feeds/{vegetableId}")         
	public ResponseEntity<List<Feedback>> viewAllFeedbacks(@PathVariable("vegetableId") int vegetableId)
			throws FeedbackNotFoundException {
		List<Feedback> viewfeed = null;
		viewfeed = service.viewAllFeedbacks(vegetableId);
		if (viewfeed.isEmpty()) {
			throw new FeedbackNotFoundException("no Feedback is present with vegetable Id: " + vegetableId);
		}
		return new ResponseEntity<List<Feedback>>(viewfeed, HttpStatus.OK);
	}
	
	 // Using GET Mapping fetching results from Customer id

	@GetMapping("/custfeed/{customerId}")       
	public ResponseEntity<List<Feedback>> viewFeedback(@PathVariable("customerId") int customerId)
			throws FeedbackNotFoundException {
		List<Feedback> feedlist2 = null;
		feedlist2 = service.viewFeedback(customerId);
		if (feedlist2.isEmpty()) {
			throw new FeedbackNotFoundException(
					"Sorry! no feedbacks Avalible with this Id: " + customerId + " to return");
		}
		return new ResponseEntity<List<Feedback>>(feedlist2, HttpStatus.OK);
	}
	
	  // Using GET Mapping fetching results from vegetable id
	
	@GetMapping("/ratefeed/{rating}")       
	public ResponseEntity<List<Feedback>> viewRating(@PathVariable("rating") int rating)
			throws FeedbackNotFoundException {
		List<Feedback> viewfeed = null;
		viewfeed = service.viewRating(rating);
		if (viewfeed.isEmpty()) {
			throw new FeedbackNotFoundException("No feedback present with rating : " + rating+" to return" );
		}
		return new ResponseEntity<List<Feedback>>(viewfeed, HttpStatus.OK);
	}
	

}
