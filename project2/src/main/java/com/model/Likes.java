package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Likes {

	@Id
	@Column(name = "like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeId; 
	
	
	private int likeTypeId; 
	
	private int postId; 
	
	private int userId;

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getLikeTypeId() {
		return likeTypeId;
	}

	public void setLikeTypeId(int likeTypeId) {
		this.likeTypeId = likeTypeId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Likes(int likeId, int likeTypeId, int postId, int userId) {
		super();
		this.likeId = likeId;
		this.likeTypeId = likeTypeId;
		this.postId = postId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Likes [likeId=" + likeId + ", likeTypeId=" + likeTypeId + ", postId=" + postId + ", userId=" + userId
				+ "]";
	}

}
