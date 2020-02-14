package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Category;

@Repository
@Transactional
public class CategoryDao {

	private SessionFactory sesfact;
	
	@Autowired
	public CategoryDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	public List<Category> findAll() {
		return sesfact.getCurrentSession().createQuery("from categories", Category.class).list();
	}

	public Category findById(int id) {
		return sesfact.getCurrentSession().get(Category.class, id);
	}

	public Category update(Category t) {
		sesfact.getCurrentSession().update(t);
		return t;
	}

	public Category insert(Category t) {
		sesfact.getCurrentSession().save(t);
		return t;
	}

	public void delete(Category t) {
		sesfact.getCurrentSession().delete(t);
	}

	public Category findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
