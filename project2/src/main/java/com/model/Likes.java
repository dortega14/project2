package com.model;

public class Likes {

	private int likeId, likeTypeId, postId, userId;

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
