package com.vegetableapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DuplicateBillIdFoundException extends RuntimeException {
	public DuplicateBillIdFoundException () {
		super();                           //Empty constructor
	}

	public DuplicateBillIdFoundException (String message) {
		super(message);                    //Message generates here
	}


}

