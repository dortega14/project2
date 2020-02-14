package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Profile;

@Repository
@Transactional
public class ProfileDao {

	private SessionFactory sesfact;
	
	@Autowired
	public ProfileDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}
	
	public List<Profile> findAll() {
		return sesfact.getCurrentSession().createQuery("from profile", Profile.class).list();
	}

	public Profile findById(int id) {
		return sesfact.getCurrentSession().get(Profile.class, id);
	}

	public Profile update(Profile t) {
		sesfact.getCurrentSession().update(t);
		return t;
	}

	public Profile insert(Profile t) {
		sesfact.getCurrentSession().save(t);
		return t;
	}

	public void delete(Profile t) {
		sesfact.getCurrentSession().delete(t);
	}

	public Profile findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
