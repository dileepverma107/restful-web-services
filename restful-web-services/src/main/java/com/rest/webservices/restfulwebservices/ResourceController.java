package com.rest.webservices.restfulwebservices;

import java.util.*;

import javax.validation.Valid;

import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.model.CustomException;
import com.rest.webservices.model.UserNotFoundException;
import com.rest.webservices.model.Users;
import com.rest.webservices.restfulwebservices.dao.UserServiceDao;

@RestController
public class ResourceController {
	
	@Autowired
	private UserServiceDao service;
	
	@RequestMapping(method=RequestMethod.GET,path="/getAllUsers")
	public List<Users> findAll(){
		List<Users> list=service.findAll();
		return list;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/saveUsers")
	public Users save() throws CustomException{
	Users list=service.saveUser(new Users(0,"Aishwarya","12/08/1978"));
		return list;
	}
	
	@GetMapping(path="/getSingleUserById/{id}")
	public EntityModel<Users> getUserById(@PathVariable int id){
		Users user=service.findOneUser(id);
		if(user==null) {
			throw new UserNotFoundException("User Not Found");
		}
		EntityModel<Users> entityModel=EntityModel.of(user);
		 WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
		 WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).getUserById(id));
		 entityModel.add(linkTo.withRel("all-users"));
		 entityModel.add(link2.withRel("get-users-by-id"));

		return entityModel;
	}
	
	@DeleteMapping(path="/deleteSingleUserById/{id}")
	public void deleteUserById(@PathVariable int id){
		Users user=service.deleteOneUser(id);
		if(user==null) {
			throw new UserNotFoundException("User Not Found");
		}
	}
	
	@PostMapping(path="/createNewUser")
	public void createUser(@Valid @RequestBody Users user) throws CustomException {
		service.saveUser(user);
	} 

}
