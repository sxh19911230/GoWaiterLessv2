package com.gowaiterless.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="unable to find item")
public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6731603467567222926L;

	public ResourceNotFoundException(){}

	public ResourceNotFoundException(String string) {
		super(string);
	}

}
