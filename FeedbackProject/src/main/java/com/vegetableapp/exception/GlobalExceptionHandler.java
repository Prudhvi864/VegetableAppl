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
	@ExceptionHandler(FeedbackNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(FeedbackNotFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateFeedbackIdFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(DuplicateFeedbackIdFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidFeedbackFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(InvalidFeedbackFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	

}
