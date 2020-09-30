package com.cg.applicationservice.exception;


public class InvalidPropertyException extends RuntimeException {
	
	
	private static final long serialVersionUID = -6949535657788075531L;

	public InvalidPropertyException(String msg)
	{
		super(msg);
	}

}