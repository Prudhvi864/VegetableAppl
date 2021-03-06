package com.vegetableapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FeedbackNotFoundException extends RuntimeException {
	public FeedbackNotFoundException() {
		super();                 //Empty Constructor
	}

	public FeedbackNotFoundException(String message) {
		super(message);          //Message generates here
	}

}
