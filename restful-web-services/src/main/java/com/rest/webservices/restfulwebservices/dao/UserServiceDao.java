package com.rest.webservices.restfulwebservices.dao;

import java.util.*;

import org.springframework.stereotype.Component;

import com.rest.webservices.model.CustomException;
import com.rest.webservices.model.Users;

@Component
public class UserServiceDao {
	private static List<Users> user=new ArrayList<>();
	private static int idCounter=5;
	
	static {
		user.add(new Users(1,"Dileep","12/07/1997"));
		user.add(new Users(2,"Rahul","12/07/1997"));
		user.add(new Users(3,"Pratik","12/07/1997"));
		user.add(new Users(4,"Parul","12/07/1997"));
		user.add(new Users(5,"Savita","12/07/1997"));
		
	}
	
	public List<Users> findAll() {
		return user;
	}
	public Users saveUser(Users u) throws CustomException{
		if(u.getId()==0) {
		u.setId(++idCounter);	
		}else if(u.getId()==1) {
			throw new CustomException("User Id already exist");
		}
		user.add(u);
		return u;
	}
	
	public Users findOneUser(int id) {
		for(Users u:user) {
			if(u.getId()==id) {
				return u;
			}
		}
		return null;
	}
	
	public Users deleteOneUser(int id) {
		Iterator<Users> itr=user.iterator();
		while(itr.hasNext())
		{
		Users user=	itr.next();
			if(user.getId()==id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
	

}
