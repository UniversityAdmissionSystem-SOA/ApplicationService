package com.cg.applicationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = -1217504577499950252L;

	public AlreadyExistsException(String msg)
	{
		super(msg);
	}

}