package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Category;
import com.revature.service.CategoryService;

@Controller
public class CategoryController {
	
	private CategoryService cs;

	@Autowired
	public void setCs(CategoryService cs) {
		this.cs = cs;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<List<Category>> readAllCaegories(){
		return new ResponseEntity<>(cs.readAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<Category> findCategoryById(int id){
		return new ResponseEntity<>(cs.findById(id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Category> updateCategory(@RequestBody Category cat){
		return new ResponseEntity<>(cs.update(cat), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Category> insertNewCategory(@RequestBody Category cat){
		return new ResponseEntity<>(cs.insert(cat), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "", produces = "application/json")
	public ResponseEntity<Category> deleteCategory(@RequestBody int id){
		cs.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
