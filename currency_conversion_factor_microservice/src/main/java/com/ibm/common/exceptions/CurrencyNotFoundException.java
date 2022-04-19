package com.ibm.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencyNotFoundException extends RuntimeException {
	
	public CurrencyNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public CurrencyNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
