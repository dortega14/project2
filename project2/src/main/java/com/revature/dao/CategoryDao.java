package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Category;

@Repository
@Transactional
public class CategoryDao implements DaoContract<Category> {

	private SessionFactory sesfact;
	
	@Autowired
	public CategoryDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	@Override
	public List<Category> findAll() {
		return sesfact.openSession().createQuery("from categories", Category.class).list();
	}

	@Override
	public Category findById(int id) {
		return sesfact.openSession().get(Category.class, id);
	}

	@Override
	public Category update(Category t) {
		sesfact.openSession().update(t);
		return t;
	}

	@Override
	public Category insert(Category t) {
		sesfact.openSession().save(t);
		return t;
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
