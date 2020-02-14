package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.YouTubeLink;
import com.revature.service.YouTubeLinkService;

@Controller
public class YouTubeLinkController {

	private YouTubeLinkService ytls;

	@Autowired
	public void setYtls(YouTubeLinkService ytls) {
		this.ytls = ytls;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<List<YouTubeLink>> readAllCaegories(){
		return new ResponseEntity<>(ytls.readAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<YouTubeLink> findCategoryById(int id){
		return new ResponseEntity<>(ytls.findById(id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<YouTubeLink> updateCategory(@RequestBody YouTubeLink ytl){
		return new ResponseEntity<>(ytls.update(ytl), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<YouTubeLink> insertNewCategory(@RequestBody YouTubeLink ytl){
		return new ResponseEntity<>(ytls.insert(ytl), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<YouTubeLink> deleteCategory(@RequestBody int id){
		ytls.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}