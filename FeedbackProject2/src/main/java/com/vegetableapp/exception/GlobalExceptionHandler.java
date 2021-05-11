package com.vegetableapp.exception;


import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BillingIdNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(BillingIdNotFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DuplicateBillIdFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(DuplicateBillIdFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	/*
	 * @ExceptionHandler(Exception.class)
	 * 
	 * @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) public
	 * ResponseEntity<Object>globalExceptionHandler(Exception ex, WebRequest
	 * request) { ExceptionDetails exceptionDetails = new ExceptionDetails(new
	 * Date(0), ex.getMessage(), request.getDescription(false)); return new
	 * ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	

}
