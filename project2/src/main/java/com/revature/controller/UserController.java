package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.User;
import com.revature.service.UserService;

@Controller
@CrossOrigin(origins="http://localhost:3001")
public class UserController {

private UserService us;
	
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/userlist.app", produces="application/json")
	public ResponseEntity<List<User>> getAllUsersAsList() {
		return new ResponseEntity<>(us.readAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user{id}.app", produces = "application/json")
	public ResponseEntity<User> findUserById(@PathVariable("id") int id){
		return new ResponseEntity<>(us.findById(id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateuser.app", produces = "application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		return new ResponseEntity<>(us.update(user), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/newuser.app", produces = "application/json")
	public ResponseEntity<User> insertNewUser(@RequestBody User user){
		return new ResponseEntity<>(us.insert(user), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/deleteuser.app", produces = "application/json")
	public ResponseEntity<User> deleteUser(@RequestBody User user){
		us.delete(user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{name}.app", produces = "application/json")
	public ResponseEntity<User> findUserByUsername(@PathVariable("name") String name) {
		return new ResponseEntity<>(us.findByUsername(name), HttpStatus.ACCEPTED);
	}
}
