package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Category;

/**
 * @author TeamLeo
 * Contains the CRUD methods for the Category Model.
 */
@Repository
@Transactional
public class CategoryDao {

	/**
	 * SessionFactory Initialization.
	 */
	private SessionFactory sesfact;
	
	/**
	 * Automatically creates association to CategoryDao
	 * @param sesfact
	 */
	@Autowired
	public CategoryDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	/**
	 * Finds all the categories
	 * @return category
	 */
	public List<Category> findAll() {
		return sesfact.getCurrentSession().createQuery("from Category", Category.class).list();
	}

	/**
	 * Finds categories by id
	 * @param id
	 * @return category
	 */
	public Category findById(int id) {
		return sesfact.getCurrentSession().get(Category.class, id);
	}

	/**
	 * Updates Category
	 * @param t
	 * @return
	 */
	public Category update(Category t) {
		sesfact.getCurrentSession().update(t);
		return t;
	}

	/**
	 * Inserts a Category
	 * @param t
	 * @return t
	 */
	public Category insert(Category t) {
		sesfact.getCurrentSession().save(t);
		return t;
	}

	/**
	 * Deletes a Category
	 * @param t
	 */
	public void delete(Category t) {
		sesfact.getCurrentSession().delete(t);
	}

	/**
	 * Finds Category by name
	 * @param name
	 * @return null
	 */
	public Category findByName(String name) {
		return null;
	}

}
