package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;

	@Column(name = "comment")
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comment_post_id")
	private Post commentPost;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comment_user_id")
	private User commentUser;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Post getCommentPost() {
		return commentPost;
	}

	public void setCommentPost(Post commentPost) {
		this.commentPost = commentPost;
	}

	public User getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentId) {
		super();
		this.commentId = commentId;
	}

	public Comment(int commentId, String comment, Post commentPost, User commentUser) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.commentPost = commentPost;
		this.commentUser = commentUser;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commentPost=" + commentPost
				+ ", commentUser=" + commentUser + "]";
	}

}