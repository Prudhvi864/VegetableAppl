package com.vegitables.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException() {
		super();
	}

	public UserAlreadyExistsException(String msg) {
		super(msg);
	}

}
