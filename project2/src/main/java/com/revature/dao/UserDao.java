package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;

@Repository
@Transactional
public class UserDao implements DaoContract<User> {
	
	private SessionFactory sesfact;
	
	@Autowired
	public UserDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	@Override
	public List<User> findAll() {
		return sesfact.openSession().createQuery("from users", User.class).list();
	}

	@Override
	public User findById(int id) {
		return sesfact.openSession().get(User.class, id);
	}

	@Override
	public User update(User t) {
		sesfact.openSession().update(t);
		return t;
	}

	@Override
	public User insert(User t) {
		sesfact.openSession().save(t);
		return t;
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public User findByName(String name) {
		return sesfact.openSession().createQuery("from users where usernname = '" + name + "'", User.class).list().get(0);
	}

	

}
