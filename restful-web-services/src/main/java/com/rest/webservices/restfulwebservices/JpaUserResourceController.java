package com.rest.webservices.restfulwebservices;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rest.webservices.model.CustomException;
import com.rest.webservices.model.JpaUsers;
import com.rest.webservices.model.UserNotFoundException;
import com.rest.webservices.restfulwebservices.dao.JpaUsersRepository;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class JpaUserResourceController {

	
	@Autowired
	private JpaUsersRepository jpaUsersRepository;
	
	
	
	@RequestMapping(method=RequestMethod.GET,path="/jpa/getAllUsers")
	public List<JpaUsers> findAll(){
		List<JpaUsers> list=jpaUsersRepository.findAll();
		return list;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/jpa/getSingleUser/{id}")
	public Optional<JpaUsers> findSingleUser(@PathVariable int id) {
		Optional<JpaUsers> user=jpaUsersRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		return user;
	}
	
	/*
	 * @PostMapping("/jpa/createNewUser") public void createNewUser(@RequestBody
	 * JpaUsers jpauser) { jpaUsersRepository.save(jpauser); }
	 */
	@PostMapping(path="/jpa/createNewUser")
	public void createUser(@Valid @RequestBody JpaUsers user) throws CustomException {
		jpaUsersRepository.save(user);
	} 
	
}
