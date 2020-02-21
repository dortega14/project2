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

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.PostService;
import com.revature.service.UserService;


/**
 * @author TeamLeo
 * Controller layer for the Post model.
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
	
	/**
	 * Initializes UserService
	 */
	private UserService us;

	/**
	 * Initializes PostService
	 */
	private PostService ps;

	/**
	 * Automatically creates an association to PostService
	 * @param ps
	 */
	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
	}
	
	/**
	 * Maps readAllPosts to /postlist.app
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/postlist.app", produces = "application/json")
	public @ResponseBody ResponseEntity<List<Post>> readAllPosts(){
		return new ResponseEntity<>(ps.readAll(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps readAUserPosts to /userpost{id}.app
	 * @param offset
	 * @param limit
	 * @param id
	 * @return findById(id)
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/userpost{id}.app", produces = "application/json")
    public ResponseEntity<List<Post>> readAUsersPosts(@RequestParam("offset") int offset,
            @RequestParam("limit") int limit, @PathVariable("id") int id) {
        User u = us.findById(id);
        return new ResponseEntity<>(ps.tenPosts(offset, limit, u.getUserId()), HttpStatus.ACCEPTED);
    }
	 
	/**
	 * Maps findPostById(id) to /post{id}.app  
	 * @param id
	 * @return findByUser(id)
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/post{id}.app", produces = "application/json")
	public ResponseEntity<List<Post>> findPostById(@PathVariable("id") int id){
//		User u = us.findById(id);
		return new ResponseEntity<>(ps.findByUser(id), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps updatePost to /updatepost.app
	 * @param post
	 * @return update(post)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatepost.app", produces = "application/json")
	public ResponseEntity<Post> updatePost(@RequestBody Post post){
		return new ResponseEntity<>(ps.update(post), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps insertNewPost to /newpost.app
	 * @param post
	 * @return insert(post)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/newpost.app", produces = "application/json")
	public ResponseEntity<Post> insertNewPost(@RequestBody Post post){
		return new ResponseEntity<>(ps.insert(post), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps deletePost to /deletepost.app
	 * @param post
	 * @return delete(post)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deletepost.app", produces = "application/json")
	public ResponseEntity<Post> deletePost(@RequestBody Post post) {
		ps.delete(post);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
