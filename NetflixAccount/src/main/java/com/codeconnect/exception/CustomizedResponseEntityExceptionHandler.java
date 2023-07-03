package com.codeconnect.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codeconnect.model.ErrorDetails;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails ed= new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(true));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFind(Exception ex, WebRequest request) throws Exception{
		ErrorDetails ed= new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(true));
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.NOT_FOUND);
	}
	
}
