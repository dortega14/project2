package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Profile;
import com.revature.service.ProfileService;

@Controller
public class ProfileController {

	private ProfileService ps;

	@Autowired
	public void setPs(ProfileService ps) {
		this.ps = ps;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<List<Profile>> readAllCaegories(){
		return new ResponseEntity<>(ps.readAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<Profile> findCategoryById(int id){
		return new ResponseEntity<>(ps.findById(id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Profile> updateCategory(@RequestBody Profile prof){
		return new ResponseEntity<>(ps.update(prof), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Profile> insertNewCategory(@RequestBody Profile prof){
		return new ResponseEntity<>(ps.insert(prof), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Profile> deleteCategory(@RequestBody int id){
		ps.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
