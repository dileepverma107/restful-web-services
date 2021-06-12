package com.rest.webservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;


public class Users {
	
	
	private  int id;
	
	@Length(max=6,message="Name should not be more than 6 characters")
	private String name;
	
	
	private String dateOfBirth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Users(int id, String name, String dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	

}
