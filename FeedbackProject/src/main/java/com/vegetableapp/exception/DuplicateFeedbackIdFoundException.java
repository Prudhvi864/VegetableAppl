package com.vegetableapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DuplicateFeedbackIdFoundException extends RuntimeException {
	public DuplicateFeedbackIdFoundException() {
		super();            //Empty constructor
	}

	public DuplicateFeedbackIdFoundException(String message) {
		super(message);     //Message generates here
	}

}