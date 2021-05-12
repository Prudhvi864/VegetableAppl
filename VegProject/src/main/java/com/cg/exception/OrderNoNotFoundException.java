package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNoNotFoundException extends RuntimeException {
	public OrderNoNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderNoNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OrderNoNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OrderNoNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
