package com.gowaiterless.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
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
