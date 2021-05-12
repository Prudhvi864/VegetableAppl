package com.vegitables.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InValidDataFoundException extends RuntimeException{
	
	public InValidDataFoundException() {
		super();
	}

	public InValidDataFoundException(String msg) {
		super(msg);
	}

}
