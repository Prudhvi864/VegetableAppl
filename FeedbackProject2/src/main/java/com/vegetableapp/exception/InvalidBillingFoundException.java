package com.vegetableapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidBillingFoundException extends RuntimeException {
	public InvalidBillingFoundException() {
		super(); // Empty constructor
	}

	public InvalidBillingFoundException(String message) {
		super(message); // Message generates here
	}

}
