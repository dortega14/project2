package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CategoryDao;
import com.revature.model.Category;

@Service
public class CategoryService {
	
	private CategoryDao cd;

	@Autowired
	public void setCd(CategoryDao cd) {
		this.cd = cd;
	}

	public List<Category> readAll() {
		return cd.findAll();
	}
	
	public Category findById(int id) {
		return cd.findById(id);
	}
	
	public Category update(Category cat) {
		return cd.update(cat);
	}
	
	public Category insert(Category cat) {
		return cd.insert(cat);
	}
	
	public void delete(int id) {
		cd.delete(id);
	}

}
