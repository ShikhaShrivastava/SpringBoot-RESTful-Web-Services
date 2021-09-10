package com.techment.exception;

import java.util.List; //Global Exception created which can handle exception in complete project

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value= IDNotFoundException.class)
	public ResponseEntity<Object> myException(IDNotFoundException exception)
	{
		return new ResponseEntity<Object>(exception.getMsg(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= EmployeeException.class)
	public ResponseEntity<Object> myEmployeeException(EmployeeException exception)
	{
		return new ResponseEntity<Object>(exception.getMsg(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= ValidationException.class)
	public ResponseEntity<List<String>> myValidationException(ValidationException exception)
	{
		return new ResponseEntity<List<String>>(exception.getMessages(), HttpStatus.BAD_REQUEST);
	}
}
