package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Like;

@Repository
@Transactional
public class LikeDao implements DaoContract<Like> {

	private SessionFactory sesfact;
	
	@Autowired
	public LikeDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}
	
	@Override
	public List<Like> findAll() {
		return sesfact.openSession().createQuery("from likes", Like.class).list();
	}

	@Override
	public Like findById(int id) {
		return sesfact.openSession().get(Like.class, id);
	}

	@Override
	public Like update(Like t) {
		sesfact.openSession().update(t);
		return t;
	}

	@Override
	public Like insert(Like t) {
		sesfact.openSession().save(t);
		return t;
	}

	@Override
	public void delete(int id) {
		
	}

	// don't need this method for this dao
	@Override
	public Like findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
