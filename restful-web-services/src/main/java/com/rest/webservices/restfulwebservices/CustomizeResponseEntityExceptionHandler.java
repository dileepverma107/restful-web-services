package com.rest.webservices.restfulwebservices;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.model.ExceptionResponse;
import com.rest.webservices.model.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	/*
	 * @ExceptionHandler(Exception.class) public final ResponseEntity<Object>
	 * handleAllExceptions(Exception ex,WebRequest webRequest){ CustomizeException
	 * ce =new CustomizeException(new
	 * Date(),ex.getMessage(),webRequest.getDescription(false)); return new
	 * ResponseEntity(ce,HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex,WebRequest webRequest){
		ExceptionResponse ce =new ExceptionResponse(new Date(),ex.getMessage(),webRequest.getDescription(false));
		System.out.print("Checking ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		return  new ResponseEntity(ce,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse ce =new ExceptionResponse(new Date(),"Validation failed",ex.getBindingResult().toString());
		return new ResponseEntity(ce,HttpStatus.BAD_REQUEST);
	}

}
