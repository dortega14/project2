package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Post;

@Repository
@Transactional
public class PostDao implements DaoContract<Post> {
	
	private SessionFactory sesfact;
	
	@Autowired
	public PostDao(SessionFactory sesfact) {
		super();
		this.sesfact = sesfact;
	}

	@Override
	public List<Post> findAll() {
		return sesfact.openSession().createQuery("from posts order by submitted", Post.class).list();
	}

	@Override
	public Post findById(int id) {
		return sesfact.openSession().get(Post.class, id);
	}

	@Override
	public Post update(Post t) {
		sesfact.openSession().update(t);
		return t;
	}

	@Override
	public Post insert(Post t) {
		sesfact.openSession().save(t);
		return t;
	}

	@Override
	public void delete(int id) {
		sesfact.openSession().delete(new Post(id));
	}

	@Override
	public Post findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
