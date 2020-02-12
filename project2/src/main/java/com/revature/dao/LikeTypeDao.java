package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.LikeType;

@Repository
@Transactional
public class LikeTypeDao implements DaoContract<LikeType> {

	private SessionFactory sesfact;
	
	@Autowired
	public LikeTypeDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}
	
	@Override
	public List<LikeType> findAll() {
		return sesfact.openSession().createQuery("from like_types", LikeType.class).list();
	}

	@Override
	public LikeType findById(int id) {
		return sesfact.openSession().get(LikeType.class, id);
	}

	@Override
	public LikeType update(LikeType t) {
		sesfact.openSession().update(t);
		return t;
	}

	@Override
	public LikeType insert(LikeType t) {
		sesfact.openSession().save(t);
		return t;
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public LikeType findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
