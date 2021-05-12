package com.vegitables.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AdminAlreadyExistsException extends RuntimeException {

	public AdminAlreadyExistsException() {
		super();
	}

	public AdminAlreadyExistsException(String msg) {
		super(msg);
	}

}
