package com.cg.applicationservice.exception;

public class NotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = -6949535657788075531L;

	public NotFoundException(String msg)
	{
		super(msg);
	}

}