package com.gowaiterless.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceDuplicationException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4872803953270374339L;
	public ResourceDuplicationException(){}
	public ResourceDuplicationException(String s){
		super(s);
	}

}