package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer;
import com.example.entity.Feedback;
import com.example.service.ICustomerService;
import com.example.service.IFeedbackService;

@RestController
@CrossOrigin
@RequestMapping(path = "/rest/feedback")
public class FeedbackController {

	@Autowired
	IFeedbackService feedbackService;

	@Autowired
	ICustomerService customerService;

	@PostMapping("/addFeedback")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feed) {
		Feedback result = feedbackService.addFeedback(feed);
		return new ResponseEntity<Feedback>(result, HttpStatus.OK);
	}

	@GetMapping(path = "/{customerId}", produces = "application/json")
	public Optional<Feedback> getFeedbackById(@PathVariable("customerId") int id) {

		System.out.println(id);

		Customer customer = customerService.findCustomerById(id);
		int id1 = customer.getCustomerId();
		return feedbackService.viewFeedback(id1);
	}
}
