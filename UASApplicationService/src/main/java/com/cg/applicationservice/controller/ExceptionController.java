package com.cg.applicationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.applicationservice.exception.AlreadyExistsException;
import com.cg.applicationservice.exception.DuplicateException;
import com.cg.applicationservice.exception.NotFoundException;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler({NotFoundException.class,SQLException.class,NullPointerException.class})
	public ResponseEntity<Object> exception(NotFoundException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateException.class )
	public ResponseEntity<Object> exception(DuplicateException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<Object> exception(AlreadyExistsException exception)
	{
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	

}