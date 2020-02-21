package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PostDao;
import com.revature.model.Post;
/**
 * @author TeamLeo
 * This class is the only class that can communicate with the PostDao class inside of the Dao layer.
 * Service layer for the Post model.
 */
@Service
public class PostService {

	/**
	 * Initializing PostDao
	 */
	private PostDao pd;

	/**
	 * Automatically creates associations with 
	 * the PostDao
	 * @param pd
	 */
	@Autowired
	public void setPd(PostDao pd) {
		this.pd = pd;
	}
	
	/**
	 * Returns all posts
	 * @return findAll();
	 */
	public List<Post> readAll() {
		return pd.findAll();
	}
	
	/**
	 * Returns posts with an offset
	 * @param offset
	 * @param limit
	 * @param id
	 * @return tenPost
	 */
	public List<Post> tenPosts(int offset, int limit, int id) {
		return pd.tenPosts(offset, limit, id);
	}
	
	/**
	 * Returns post by id
	 * @param id(id)
	 * @return findById
	 */
	public Post findById(int id) {
		return pd.findById(id);
	}
	
	/**
	 * Inserts a post
	 * @param post
	 * @return insert(post)
	 */
	public Post insert(Post post) {
		return pd.insert(post);
	}
	
	/**
	 * Updates a post
	 * @param post
	 * @return update(post)
	 */
	public Post update(Post post) {
		return pd.update(post);
	}
	
	/**
	 * Deletes a post
	 * @param post
	 */
	public void delete(Post post) {
		pd.delete(post);
	}
	
	/**
	 * Returns post by user id
	 * @param id
	 * @return findByUser(id)
	 */
	public List<Post> findByUser(int id) {
		return pd.findByUser(id);
	}
}
