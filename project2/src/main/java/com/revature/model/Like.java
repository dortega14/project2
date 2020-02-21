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
 * This class contains the details for 
 * liking recipe posts.
 */
@Entity
@Table(name = "likes")
public class Like {

	/**
	 * Primary key for like.
	 */
	@Id
	@Column(name = "like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeId;

	/**
	 * Foreign key for like type.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "like_like_type_id")
	private LikeType likeLikeType;

	/**
	 * Foreign key to link like to post.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "like_post_id")
	@JsonIgnore
	private Post likePost;

	/**
	 * Foreign key to link like to user.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "like_user_id")
	@JsonIgnore
	private User likeUser;

	/**
	 * getter for likeId.
	 * @return likeId
	 */
	public int getLikeId() {
		return likeId;
	}

	/**
	 * setter for likeId.
	 * @param likeId
	 */
	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	/**
	 * getter for likeLikeType.
	 * @return likeLikeType
	 */
	public LikeType getLikeLikeType() {
		return likeLikeType;
	}

	/**
	 * setter for likeLikeType.
	 * @param likeLikeType
	 */
	public void setLikeLikeType(LikeType likeLikeType) {
		this.likeLikeType = likeLikeType;
	}

	/**
	 * getter for likePost.
	 * @return likePost
	 */
	public Post getLikePost() {
		return likePost;
	}

	/**
	 * setter for likePost.
	 * @param likePost
	 */
	public void setLikePost(Post likePost) {
		this.likePost = likePost;
	}

	/**
	 * getter for likeUser.
	 * @return likeUser
	 */
	public User getLikeUser() {
		return likeUser;
	}

	/**
	 * setter for likeUser
	 * @param likeUser
	 */
	public void setLikeUser(User likeUser) {
		this.likeUser = likeUser;
	}

	/**
	 * No-args constructor
	 */
	public Like() {
		super();
	}

	/**
	 * Like object constructor
	 * @param likeId
	 * @param likeLikeType
	 * @param likePost
	 * @param likeUser
	 */
	public Like(int likeId, LikeType likeLikeType, Post likePost, User likeUser) {
		super();
		this.likeId = likeId;
		this.likeLikeType = likeLikeType;
		this.likePost = likePost;
		this.likeUser = likeUser;
	}

	/**
	 * Like toString method
	 */
	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", likeLikeType=" + likeLikeType + ", likePost=" + likePost + ", likeUser="
				+ likeUser + "]";
	}

}
