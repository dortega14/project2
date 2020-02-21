package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CategoryDao;
import com.revature.model.Category;

/**
 * @author TeamLeo
 * Service layer for the Category model.
 */
@Service
public class CategoryService {
	
	/**
	 * CategoryDao Instantiation.
	 */
	private CategoryDao cd;

	/**
	 * Automatically creates associations for the 
	 * Category.
	 * @param cd
	 */
	@Autowired
	public void setCd(CategoryDao cd) {
		this.cd = cd;
	}

	/**
	 * 
	 * @return cd.findAll()
	 */
	public List<Category> readAll() {
		return cd.findAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return findById(id)
	 */
	public Category findById(int id) {
		return cd.findById(id);
	}
	
	/**
	 * 
	 * @param cat
	 * @return update(cat)
	 */
	public Category update(Category cat) {
		return cd.update(cat);
	}
	
	/**
	 * 
	 * @param cat
	 * @return insert
	 */
	public Category insert(Category cat) {
		return cd.insert(cat);
	}
	
	/**
	 * 
	 * @param cat
	 */
	public void delete(Category cat) {
		cd.delete(cat);
	}

}
