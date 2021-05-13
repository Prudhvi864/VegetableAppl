package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateCustomerFoundException extends RuntimeException {

	public DuplicateCustomerFoundException() {
		super();
	}

	public DuplicateCustomerFoundException(String str) {
		super(str);
	}
}
