package com.techment.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = InvalidUserExcpetion.class)
	public ResponseEntity<Object> myException(InvalidUserExcpetion exception)
	{
		return new ResponseEntity<Object>(exception.getMsg(), HttpStatus.UNAUTHORIZED);
	}

}
