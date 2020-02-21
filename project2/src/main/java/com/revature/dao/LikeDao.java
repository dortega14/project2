package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Like;

/**
 * @author TeamLeo
 * Contains the CRUD methods for the Like Model.
 */
@Repository
@Transactional
public class LikeDao {

	private SessionFactory sesfact;
	
	@Autowired
	public LikeDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}
	
	public List<Like> findAll() {
		return sesfact.getCurrentSession().createQuery("from Like", Like.class).list();
	}

	public Like findById(int id) {
		return sesfact.getCurrentSession().get(Like.class, id);
	}

	public Like update(Like t) {
		sesfact.getCurrentSession().update(t);
		return t;
	}

	public Like insert(Like t) {
		sesfact.getCurrentSession().save(t);
		return t;
	}

	public void delete(Like t) {
		sesfact.getCurrentSession().delete(t);
	}

	// don't need this method for this dao
	public Like findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
