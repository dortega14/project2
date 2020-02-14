package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Comment;
import com.revature.service.CommentService;

@Controller
public class CommentController {
	
	private CommentService cs;

	@Autowired
	public void setCs(CommentService cs) {
		this.cs = cs;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<List<Comment>> readAllCaegories(){
		return new ResponseEntity<>(cs.readAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<Comment> findCategoryById(int id){
		return new ResponseEntity<>(cs.findById(id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Comment> updateCategory(@RequestBody Comment comm){
		return new ResponseEntity<>(cs.update(comm), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Comment> insertNewCategory(@RequestBody Comment comm){
		return new ResponseEntity<>(cs.insert(comm), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Comment> deleteCategory(@RequestBody int id){
		cs.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}