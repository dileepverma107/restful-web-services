package com.rest.webservices.model;

public class Employee {
 private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public Employee(String message) {
	this.message = message;
}

@Override
public String toString() {
	return "Employee [message=" + message + "]";
}
 
}
