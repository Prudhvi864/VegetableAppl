package com.cg.exception;

	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class OrderDateNotFoundException extends RuntimeException
	{
		public OrderDateNotFoundException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public OrderDateNotFoundException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public OrderDateNotFoundException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

		public OrderDateNotFoundException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}


}
