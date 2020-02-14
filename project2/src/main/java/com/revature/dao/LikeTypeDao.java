package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.LikeType;

@Repository
@Transactional
public class LikeTypeDao {

	private SessionFactory sesfact;
	
	@Autowired
	public LikeTypeDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}
	
	public List<LikeType> findAll() {
		return sesfact.getCurrentSession().createQuery("from like_types", LikeType.class).list();
	}

	public LikeType findById(int id) {
		return sesfact.getCurrentSession().get(LikeType.class, id);
	}

	public LikeType update(LikeType t) {
		sesfact.getCurrentSession().update(t);
		return t;
	}

	public LikeType insert(LikeType t) {
		sesfact.getCurrentSession().save(t);
		return t;
	}

	public void delete(LikeType t) {
		sesfact.getCurrentSession().delete(t);
	}

	public LikeType findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
