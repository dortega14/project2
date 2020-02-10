package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.driver.Log4j;
import com.model.Category;
import com.util.HibernateUtil;

@Repository
public class CategoryDao implements DaoContract<Category> {

	
	
	public CategoryDao() {
		HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category insert(Category t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		Log4j.log.info("New category has been created.");
		return t;
	}

	@Override
	public Category delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
