package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Comment;

@Repository
@Transactional
public class CommentDao implements DaoContract<Comment> {

	private SessionFactory sesfact;
	
	@Autowired
	public CommentDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}
	
	@Override
	public List<Comment> findAll() {
		return sesfact.openSession().createQuery("from comments", Comment.class).list();
	}

	@Override
	public Comment findById(int id) {
		return sesfact.openSession().get(Comment.class, id);
	}

	@Override
	public Comment update(Comment t) {
		sesfact.openSession().update(t);
		return t;
	}

	@Override
	public Comment insert(Comment t) {
		sesfact.openSession().save(t);
		return t;
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public Comment findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
