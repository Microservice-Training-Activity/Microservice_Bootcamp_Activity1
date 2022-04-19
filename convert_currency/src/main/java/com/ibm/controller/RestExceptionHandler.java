package com.ibm.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(value = {HttpClientErrorException.class})
protected ResponseEntity<Object> handleConflict(HttpClientErrorException ex, WebRequest request) {

    return handleExceptionInternal(ex, ex.getResponseBodyAsString(),
            new HttpHeaders(), ex.getStatusCode(), request);

    }

}