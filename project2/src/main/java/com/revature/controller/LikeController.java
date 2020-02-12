package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Like;
import com.revature.service.LikeService;

@Controller
public class LikeController {
	
	private LikeService ls;

	@Autowired
	public void setLs(LikeService ls) {
		this.ls = ls;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<List<Like>> readAllCaegories(){
		return new ResponseEntity<>(ls.readAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<Like> findCategoryById(int id){
		return new ResponseEntity<>(ls.findById(id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Like> updateCategory(@RequestBody Like like){
		return new ResponseEntity<>(ls.update(like), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Like> insertNewCategory(@RequestBody Like like){
		return new ResponseEntity<>(ls.insert(like), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Like> deleteCategory(@RequestBody int id){
		ls.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
