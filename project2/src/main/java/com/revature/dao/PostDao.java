package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Post;

@Repository
@Transactional
public class PostDao {
	
	private SessionFactory sesfact;
	
	@Autowired
	public PostDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	public List<Post> findAll() {
		return sesfact.getCurrentSession().createQuery("from posts order by submitted", Post.class).list();
	}

	public Post findById(int id) {
		return sesfact.getCurrentSession().get(Post.class, id);
	}

	public Post update(Post t) {
		sesfact.getCurrentSession().update(t);
		return t;
	}

	public Post insert(Post t) {
		sesfact.getCurrentSession().save(t);
		return t;
	}

	public void delete(Post t) {
		sesfact.getCurrentSession().delete(t);
	}

	public Post findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
