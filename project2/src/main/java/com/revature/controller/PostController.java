package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Post;
import com.revature.service.PostService;

@Controller
public class PostController {

	private PostService ps;

	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
//	public ResponseEntity<List<Post>> readAllPosts(){
//		return new ResponseEntity<>(ps.readAll(), HttpStatus.ACCEPTED);
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
//	public ResponseEntity<Post> findPostById(int id){
//		return new ResponseEntity<>(ps.findById(id), HttpStatus.ACCEPTED);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
//	public ResponseEntity<Post> updatePost(@RequestBody Post post){
//		return new ResponseEntity<>(ps.update(post), HttpStatus.ACCEPTED);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
//	public ResponseEntity<Post> insertNewPost(@RequestBody Post post){
//		return new ResponseEntity<>(ps.insert(post), HttpStatus.ACCEPTED);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
//	public ResponseEntity<Post> deletePost(@RequestBody Post post) {
//		ps.delete(post);
//		return new ResponseEntity<>(HttpStatus.ACCEPTED);
//	}
	
	
}
