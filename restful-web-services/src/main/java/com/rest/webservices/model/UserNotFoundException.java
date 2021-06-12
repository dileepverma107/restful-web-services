package com.rest.webservices.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	 public UserNotFoundException(String mess) {
		 super(mess);
	 }
}
