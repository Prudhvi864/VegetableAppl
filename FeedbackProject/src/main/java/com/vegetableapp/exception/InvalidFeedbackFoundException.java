package com.vegetableapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidFeedbackFoundException extends RuntimeException {
	public InvalidFeedbackFoundException() {
		super();                 //Empty Constructor
	}

	public InvalidFeedbackFoundException(String message) {
		super(message);          //Message generates here
	}

}
