package com.acmefresh.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ProductsException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(ProductsException ie,WebRequest wr) {
	System.out.println("inside ProductsException method...");
	MyErrorDetails err=new MyErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.setMessage(ie.getMessage());
	err.setDetails(wr.getDescription(false));
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(CustomerException ie,WebRequest wr) {
	System.out.println("inside CustomerException method...");
	MyErrorDetails err=new MyErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.setMessage(ie.getMessage());
	err.setDetails(wr.getDescription(false));
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(UserAlreadyExists ie,WebRequest wr) {
	System.out.println("inside UserAlreadyExists method...");
	MyErrorDetails err=new MyErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.setMessage(ie.getMessage());
	err.setDetails(wr.getDescription(false));
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(Exception ie,WebRequest wr) {
	System.out.println("inside Exception method...");
	MyErrorDetails err=new MyErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.setMessage(ie.getMessage());
	err.setDetails(wr.getDescription(false));
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(NoHandlerFoundException ie,WebRequest wr) {
	System.out.println("inside NoHandlerFoundException method...");
	MyErrorDetails err=new MyErrorDetails();
	err.setTimestamp(LocalDateTime.now());
	err.setMessage(ie.getMessage());
	err.setDetails(wr.getDescription(false));
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
}
