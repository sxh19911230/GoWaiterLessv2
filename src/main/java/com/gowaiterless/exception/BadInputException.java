package com.gowaiterless.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY, reason="Invalid parameter")
public class BadInputException extends RuntimeException {

	private static final long serialVersionUID = 6772305583127042320L;
	public BadInputException(){}
	public BadInputException(String e) {super(e);}
}
