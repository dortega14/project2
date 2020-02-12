package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PostDao;
import com.revature.model.Post;
/**
 * 
 * @author TeamLeo
 * <br>
 * <br>
 * This class is the only class that can communicate with the PostDao class inside of the Dao layer.
 * 
 *
 */
@Service
public class PostService {

	private PostDao pd;

	@Autowired
	public void setPd(PostDao pd) {
		this.pd = pd;
	}
	
	public List<Post> readAll() {
		return pd.findAll();
	}
	
	public Post findById(int id) {
		return pd.findById(id);
	}
	
	public Post insert(Post post) {
		return pd.insert(post);
	}
	
	public Post update(Post post) {
		return pd.update(post);
	}
	
	public void delete(int id) {
		pd.delete(id);
	}
}
