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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {

	@Id
	@Column(name = "like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "like_like_type_id")
	private LikeType likeLikeType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "like_post_id")
	private Post likePost;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "like_user_id")
	private User likeUser;

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public LikeType getLikeLikeType() {
		return likeLikeType;
	}

	public void setLikeLikeType(LikeType likeLikeType) {
		this.likeLikeType = likeLikeType;
	}

	public Post getLikePost() {
		return likePost;
	}

	public void setLikePost(Post likePost) {
		this.likePost = likePost;
	}

	public User getLikeUser() {
		return likeUser;
	}

	public void setLikeUser(User likeUser) {
		this.likeUser = likeUser;
	}

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int likeId, LikeType likeLikeType, Post likePost, User likeUser) {
		super();
		this.likeId = likeId;
		this.likeLikeType = likeLikeType;
		this.likePost = likePost;
		this.likeUser = likeUser;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", likeLikeType=" + likeLikeType + ", likePost=" + likePost + ", likeUser="
				+ likeUser + "]";
	}

}
