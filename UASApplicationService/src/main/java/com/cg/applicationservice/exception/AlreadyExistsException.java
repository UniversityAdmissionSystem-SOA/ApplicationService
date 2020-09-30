package com.cg.applicationservice.exception;


public class AlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = -1217504577499950252L;

	public AlreadyExistsException(String msg)
	{
		super(msg);
	}

}