package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Profile;

@Repository
@Transactional
public class ProfileDao implements DaoContract<Profile> {

	private SessionFactory sesfact;
	
	@Autowired
	public ProfileDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}
	
	@Override
	public List<Profile> findAll() {
		return sesfact.openSession().createQuery("from profile", Profile.class).list();
	}

	@Override
	public Profile findById(int id) {
		return sesfact.openSession().get(Profile.class, id);
	}

	@Override
	public Profile update(Profile t) {
		sesfact.openSession().update(t);
		return t;
	}

	@Override
	public Profile insert(Profile t) {
		sesfact.openSession().save(t);
		return t;
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public Profile findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
