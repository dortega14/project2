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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.PaginateReq;
import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.PostService;
import com.revature.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
	
	private UserService us;

	private PostService ps;

	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/postlist.app", produces = "application/json")
	public @ResponseBody ResponseEntity<List<Post>> readAllPosts(){
		return new ResponseEntity<>(ps.readAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/userpost.app", produces = "application/json")
	public ResponseEntity<List<Post>> readAUsersPosts(@RequestBody int id) {
        User u = us.findById(id);
        PaginateReq pr = new PaginateReq();
        pr.setUser(u);
        User user = pr.getUser();
        return new ResponseEntity<>(ps.tenPosts(pr.getOffset(), pr.getLimit(), user.getUserId()), HttpStatus.ACCEPTED);
    }
	 
	@RequestMapping(method = RequestMethod.GET, value = "/post{id}.app", produces = "application/json")
	public ResponseEntity<List<Post>> findPostById(@PathVariable("id") int id){
//		User u = us.findById(id);
		return new ResponseEntity<>(ps.findByUser(id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updatepost.app", produces = "application/json")
	public ResponseEntity<Post> updatePost(@RequestBody Post post){
		return new ResponseEntity<>(ps.update(post), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/newpost.app", produces = "application/json")
	public ResponseEntity<Post> insertNewPost(@RequestBody Post post){
		return new ResponseEntity<>(ps.insert(post), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/deletepost.app", produces = "application/json")
	public ResponseEntity<Post> deletePost(@RequestBody Post post) {
		ps.delete(post);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
