package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.LikeType;
import com.revature.service.LikeTypeService;

/**
 * @author TeamLeo
 * Controller layer for the LikeType model.
 */
@Controller
public class LikeTypeController {
	
	private LikeTypeService lts;

	@Autowired
	public void setLts(LikeTypeService lts) {
		this.lts = lts;
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
//	public ResponseEntity<List<LikeType>> readAllLikeTypes(){
//		return new ResponseEntity<>(lts.readAll(), HttpStatus.ACCEPTED);
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
//	public ResponseEntity<LikeType> findLikeTypeById(int id){
//		return new ResponseEntity<>(lts.findById(id), HttpStatus.ACCEPTED);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
//	public ResponseEntity<LikeType> updateLikeType(@RequestBody LikeType lt){
//		return new ResponseEntity<>(lts.update(lt), HttpStatus.ACCEPTED);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
//	public ResponseEntity<LikeType> insertNewLikeType(@RequestBody LikeType lt){
//		return new ResponseEntity<>(lts.insert(lt), HttpStatus.ACCEPTED);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
//	public ResponseEntity<LikeType> deleteLikeType(@RequestBody LikeType lt){
//		lts.delete(lt);
//		return new ResponseEntity<>(HttpStatus.ACCEPTED);
//	}

}
