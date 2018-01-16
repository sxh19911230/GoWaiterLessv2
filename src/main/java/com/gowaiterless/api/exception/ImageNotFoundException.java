package com.gowaiterless.api.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageNotFoundException extends RuntimeException {

	public ImageNotFoundException(){}
	
	public ImageNotFoundException(Exception e) {
		super(e);
	}
	public ImageNotFoundException(String s) {
		super(s);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
