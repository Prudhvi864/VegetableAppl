package com.vegetableapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BillingIdNotFoundException extends RuntimeException {
	public BillingIdNotFoundException() {
		super();                        //Empty constructor
	}

	public BillingIdNotFoundException(String message) {
		super(message);                 //Message generates here
	}


}
