package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author TeamLeo
 * The comment model contains the details
 * of a comment for making comments on a
 * post.
 */
@Entity
@Table(name = "comments")
public class Comment {

	/**
	 * Primary key for comment.
	 */
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;

	/**
	 * Name for comment.
	 */
	@Column(name = "comment")
	private String comment;

	/**
	 * Comment for post.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_post_id")
	@JsonIgnore
	private Post commentPost;

	/**
	 * Comment created by user.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_user_id")
	@JsonIgnore
	private User commentUser;

	/**
	 * getter for commentId.
	 * @return commentId
	 */
	public int getCommentId() {
		return commentId;
	}

	/**
	 * setter for commentId.
	 * @param commentId
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	/**
	 * getter for comment.
	 * @return comment.
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * setter for comment.
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * getter for commentPost.
	 * @return commentPost
	 */
	public Post getCommentPost() {
		return commentPost;
	}

	/**
	 * setter for commentPost.
	 * @param commentPost
	 */
	public void setCommentPost(Post commentPost) {
		this.commentPost = commentPost;
	}

	/**
	 * getter for user who made a comment.
	 * @return commentUser
	 */
	public User getCommentUser() {
		return commentUser;
	}

	/**
	 * setter for user who will add a comment.
	 * @param commentUser
	 */
	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}

	/**
	 * No-args Comment constructor.
	 */
	public Comment() {
		super();
	}

	/**
	 * Comment constructor with id param.
	 * @param commentId
	 */
	public Comment(int commentId) {
		super();
		this.commentId = commentId;
	}

	/**
	 * Object constructor for Comment.
	 * @param commentId
	 * @param comment
	 * @param commentPost
	 * @param commentUser
	 */
	public Comment(int commentId, String comment, Post commentPost, User commentUser) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.commentPost = commentPost;
		this.commentUser = commentUser;
	}

	/**
	 * Comment toString method.
	 */
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commentPost=" + commentPost
				+ ", commentUser=" + commentUser + "]";
	}

}