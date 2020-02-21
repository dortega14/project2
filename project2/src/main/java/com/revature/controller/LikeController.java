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

import com.revature.model.Like;
import com.revature.service.LikeService;

/**
 * @author TeamLeo
 * Controller layer for the Like model.
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class LikeController {
	
	/**
	 * Initializes LikeService
	 */
	private LikeService ls;

	/**
	 * Automatically creates an association to 
	 * LikeService
	 * @param ls
	 */
	@Autowired
	public void setLs(LikeService ls) {
		this.ls = ls;
	}
	
	/**
	 * Maps the readAllLikes to /likelist.app
	 * @return readAll()
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/likelist.app", produces = "application/json")
	public ResponseEntity<List<Like>> readAllLikes(){
		return new ResponseEntity<>(ls.readAll(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps the findLikeById to /like(id number).app
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/like{id}.app", produces = "application/json")
	public ResponseEntity<Like> findLikeById(@PathVariable("id") int id){
		return new ResponseEntity<>(ls.findById(id), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps the updateLike to /updatelike.app
	 * @param like
	 * @return update(like)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatelike.app", produces = "application/json")
	public ResponseEntity<Like> updateLike(@RequestBody Like like){
		return new ResponseEntity<>(ls.update(like), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps the insertNewLike to /newlike.app
	 * @param like
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/newlike.app", produces = "application/json")
	public ResponseEntity<Like> insertNewLike(@RequestBody Like like){
		return new ResponseEntity<>(ls.insert(like), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps the deleteLike top /deletelike.app
	 * @param like
	 * @return delete(like)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deletelike.app", produces = "application/json")
	public ResponseEntity<Like> deleteLike(@RequestBody Like like){
		ls.delete(like);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
