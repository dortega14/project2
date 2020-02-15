package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;

@Repository
@Transactional
public class UserDao {
	
	private SessionFactory sesfact;
	
	@Autowired
	public UserDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	public List<User> findAll() {
		return sesfact.getCurrentSession().createQuery("from User", User.class).list();
	}

	public User findById(int id) {
		return sesfact.getCurrentSession().get(User.class, id);
	}

	public User update(User t) {
		sesfact.getCurrentSession().update(t);
		return t;
	}

	public User insert(User t) {
		sesfact.getCurrentSession().save(t);
		return t;
	}

	public void delete(User t) {
		sesfact.getCurrentSession().delete(t);
	}

	public User findByName(String name) {
		return sesfact.getCurrentSession().createQuery("from User where username = '" + name + "'", User.class).list().get(0);
	}

	

}
