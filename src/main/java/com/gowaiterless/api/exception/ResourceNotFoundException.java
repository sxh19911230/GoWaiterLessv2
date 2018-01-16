package com.gowaiterless.api.exception;

import java.io.IOException;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6731603467567222926L;

	public ResourceNotFoundException(){}

	public ResourceNotFoundException(String string) {
		super(string);
	}

	public ResourceNotFoundException(Exception e) {
		super(e);
	}

}
