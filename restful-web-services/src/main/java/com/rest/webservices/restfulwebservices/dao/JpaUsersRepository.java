package com.rest.webservices.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.webservices.model.JpaUsers;

@Repository
public interface JpaUsersRepository extends JpaRepository<JpaUsers,Integer>{

}
