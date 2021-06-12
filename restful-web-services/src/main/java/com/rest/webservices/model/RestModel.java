package com.rest.webservices.model;

public class RestModel {
	public String name;
	public String city;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "RestModel [name=" + name + ", city=" + city + "]";
	}
	

}
