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

import com.revature.model.Comment;
import com.revature.service.CommentService;

/**
 * @author TeamLeo
 * Controller layer for the comment model.
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {
	
	/**
	 * CommentService initialization.
	 */
	private CommentService cs;

	/**
	 * Automatically creates associations
	 * from CommentController to CommentService
	 * @param cs
	 */
	@Autowired
	public void setCs(CommentService cs) {
		this.cs = cs;
	}
	
	/**
	 * Maps the readAllComments() to /comlist.app
	 * @return readAll()
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/commlist.app", produces = "application/json")
	public @ResponseBody ResponseEntity<List<Comment>> readAllComments(){
		return new ResponseEntity<>(cs.readAll(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps the findCommentById to /comment(id number).app
	 * @param id
	 * @return findById(id)
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/comment{id}.app", produces = "application/json")
	public ResponseEntity<Comment> findCommentById(@PathVariable("id") int id){
		return new ResponseEntity<>(cs.findById(id), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps the updateComment to /updatecomm.app
	 * @param comm
	 * @return update(comm)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatecomm.app", produces = "application/json")
	public ResponseEntity<Comment> updateComment(@RequestBody Comment comm){
		return new ResponseEntity<>(cs.update(comm), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps the insertNewComment to /newcomm.app
	 * @param comm
	 * @return insert()
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/newcomm.app", produces = "application/json")
	public ResponseEntity<Comment> insertNewComment(@RequestBody Comment comm){
		return new ResponseEntity<>(cs.insert(comm), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps the deleteComment to /deletecomm.app
	 * @param comm
	 * @return delete(comm)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deletecomm.app", produces = "application/json")
	public ResponseEntity<Comment> deleteComment(@RequestBody Comment comm){
		cs.delete(comm);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
