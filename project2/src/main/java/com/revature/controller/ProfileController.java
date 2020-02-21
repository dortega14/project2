package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Profile;
import com.revature.service.ProfileService;

/**
 * @author TeamLeo
 * Controller layer for the profile model.
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileController {

	/**
	 * ProfileService instantiation
	 */
	private ProfileService ps;

	/**
	 * Automatically creates an association to ProfileService
	 * @param ps
	 */
	@Autowired
	public void setPs(ProfileService ps) {
		this.ps = ps;
	}
	
	/**
	 * Maps readAllProfiles to /proflist.app
	 * @return ps.readAll()
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/proflist.app", produces = "application/json")
	public @ResponseBody ResponseEntity<List<Profile>> readAllProfiles(){
		return new ResponseEntity<>(ps.readAll(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps findProfileById to /prof{id}.app
	 * @param id
	 * @return ps.findById(id)
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/prof{id}.app", produces = "application/json")
	public ResponseEntity<Profile> findProfileById(@PathVariable("id") int id){
		return new ResponseEntity<>(ps.findById(id), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps updateProfile to /updateprof.app
	 * @param prof
	 * @return ps.update(prof)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updateprof.app", produces = "application/json")
	public ResponseEntity<Profile> updateProfile(@RequestBody Profile prof){
		return new ResponseEntity<>(ps.update(prof), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps insertNewProfile to /newprof.app
	 * @param prof
	 * @return ps.insert(prof)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/newprof.app", produces = "application/json")
	public ResponseEntity<Profile> insertNewProfile(@RequestBody Profile prof){
		return new ResponseEntity<>(ps.insert(prof), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps deleteProfile to /deleteprof.app
	 * @param prof
	 * @return ps.delete(prof)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deleteprof.app", produces = "application/json")
	public ResponseEntity<Profile> deleteProfile(@RequestBody Profile prof){
		ps.delete(prof);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
