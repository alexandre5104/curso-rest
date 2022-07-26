package com.alexandre.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message) {
		super(message);
	}
	
	public ObjectNotFoundException(String messaage, Throwable cause) {
		super(messaage, cause);
	}
}
