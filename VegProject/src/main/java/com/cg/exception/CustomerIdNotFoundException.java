package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerIdNotFoundException extends RuntimeException
{
	public CustomerIdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerIdNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerIdNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}