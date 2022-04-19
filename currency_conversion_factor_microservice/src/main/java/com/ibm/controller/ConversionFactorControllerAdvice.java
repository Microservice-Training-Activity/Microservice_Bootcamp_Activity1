package com.ibm.controller;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ibm.common.exceptions.CurrencyNotFoundException;
import com.ibm.common.exceptions.ErrorDetails;


@RestControllerAdvice
public class ConversionFactorControllerAdvice {

	@ExceptionHandler(CurrencyNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleConversionFactorNotFound(CurrencyNotFoundException e)
	{
		ErrorDetails ed = new ErrorDetails("Currency-404", "Currency Not Found!", LocalDateTime.now());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ed);
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleInvalidConversionFactor(MethodArgumentNotValidException e)
	{
		e.printStackTrace();
		ErrorDetails ed = new ErrorDetails("Currency-400", "Currency length must be greater than or equal 3!", LocalDateTime.now());
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
	}
	
}
