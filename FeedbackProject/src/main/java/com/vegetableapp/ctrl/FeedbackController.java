package com.vegetableapp.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetableapp.entity.Feedback;
import com.vegetableapp.exception.DuplicateFeedbackIdFoundException;
import com.vegetableapp.exception.FeedbackNotFoundException;
import com.vegetableapp.entity.Customer;
import com.vegetableapp.service.FeedbackService;

@RestController
@RequestMapping("rest/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService service;

	/*
	 * @PostMapping("/addFeedback") public ResponseEntity<Feedback>
	 * addFeedback(@RequestBody Feedback feed) { Feedback result =
	 * service.addFeedback(feed); return new ResponseEntity<Feedback>(result,
	 * HttpStatus.OK); }
	 */
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
	/*
	 * @GetMapping(path="/custfeed",consumes="application/json") public
	 * ResponseEntity<List<Feedback>> viewFeedback(@RequestBody Customer customer){
	 * //System.out.println("hello"+customerId); //int
	 * custId=Integer.parseInt(customerId); List<Feedback> feedlist2
	 * =service.viewFeedback(customer); if(feedlist2==null) { return new
	 * ResponseEntity("Sorry! no feedbacks Avalible with this Id!",HttpStatus.
	 * NOT_FOUND); } return new
	 * ResponseEntity<List<Feedback>>(feedlist2,HttpStatus.OK); }
	 */
}
