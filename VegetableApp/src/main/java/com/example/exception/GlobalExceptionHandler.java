package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		 ExceptionResponse response = new ExceptionResponse();
	        response.setDateTime(LocalDateTime.now());
	        response.setMessage("Customer not found");
	        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	        return entity;
	}

	@ExceptionHandler(DuplicateCustomerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(DuplicateCustomerFoundException ex, WebRequest request) {
		 ExceptionResponse response = new ExceptionResponse();
	        response.setDateTime(LocalDateTime.now());
	        response.setMessage("Duplicate customer is not allowed");
	        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	        return entity;
	}
}
