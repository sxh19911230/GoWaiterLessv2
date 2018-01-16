package com.gowaiterless.api.exception;

public class BadInputException extends RuntimeException {

	private static final long serialVersionUID = 6772305583127042320L;
	public BadInputException(){}
	public BadInputException(String e) {super(e);}
}
