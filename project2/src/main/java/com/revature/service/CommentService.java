package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CommentDao;
import com.revature.model.Comment;

/**
 * 
 * @author TeamLeo
 * <br>
 * <br>
 * This class is the only class that can communicate with the CommentDao class inside of the Dao layer.
 * 
 *
 */
@Service
public class CommentService {
	
	private CommentDao cd;

	@Autowired
	public void setCd(CommentDao cd) {
		this.cd = cd;
	}
	
	public List<Comment> readAll() {
		return cd.findAll();
	}
	
	public Comment findById(int id) {
		return cd.findById(id);
	}
	
	public Comment update(Comment comment) {
		return cd.update(comment);
	}
	
	public Comment insert(Comment comment) {
		return cd.insert(comment);
	}
	
	public void delete(int id) {
		cd.delete(id);
	}

}
