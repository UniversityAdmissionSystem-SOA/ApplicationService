package com.cg.applicationservice.exception;

public class DuplicateException extends RuntimeException {
	private static final long serialVersionUID = -1217504577499950252L;

	public DuplicateException(String msg)
	{
		super(msg);
	}

}