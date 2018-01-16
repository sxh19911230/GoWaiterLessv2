package com.gowaiterless.api.exception;

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
