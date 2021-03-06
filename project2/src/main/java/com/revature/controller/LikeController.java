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

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class LikeController {
	
	private LikeService ls;

	@Autowired
	public void setLs(LikeService ls) {
		this.ls = ls;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/likelist.app", produces = "application/json")
	public ResponseEntity<List<Like>> readAllLikes(){
		return new ResponseEntity<>(ls.readAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/like{id}.app", produces = "application/json")
	public ResponseEntity<Like> findLikeById(@PathVariable("id") int id){
		return new ResponseEntity<>(ls.findById(id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updatelike.app", produces = "application/json")
	public ResponseEntity<Like> updateLike(@RequestBody Like like){
		return new ResponseEntity<>(ls.update(like), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/newlike.app", produces = "application/json")
	public ResponseEntity<Like> insertNewLike(@RequestBody Like like){
		return new ResponseEntity<>(ls.insert(like), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/deletelike.app", produces = "application/json")
	public ResponseEntity<Like> deleteLike(@RequestBody Like like){
		ls.delete(like);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
