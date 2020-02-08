package com.model;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	@Column(name = "title")
	private String title;

	@Column(name = "image")
	private Blob image;

	@Column(name = "recipe")
	private String recipe;

	@Column(name = "ingredients")
	private String ingredients;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_post_id")
	private Category postCategory;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "post_user_id")
	private User postUser;

	@OneToMany(mappedBy = "ytPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<YouTubeLink> postYtLink;

	@OneToMany(mappedBy = "commentPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> postComment;

	@OneToMany(mappedBy = "likePost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Like> postLike;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Category getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(Category postCategory) {
		this.postCategory = postCategory;
	}

	public User getPostUser() {
		return postUser;
	}

	public void setPostUser(User postUser) {
		this.postUser = postUser;
	}

	public Set<YouTubeLink> getPostYtLink() {
		return postYtLink;
	}

	public void setPostYtLink(Set<YouTubeLink> postYtLink) {
		this.postYtLink = postYtLink;
	}

	public Set<Comment> getPostComment() {
		return postComment;
	}

	public void setPostComment(Set<Comment> postComment) {
		this.postComment = postComment;
	}

	public Set<Like> getPostLike() {
		return postLike;
	}

	public void setPostLike(Set<Like> postLike) {
		this.postLike = postLike;
	}

	public Post(int postId, String title, Blob image, String recipe, String ingredients, Category postCategory,
			User postUser, Set<YouTubeLink> postYtLink, Set<Comment> postComment, Set<Like> postLike) {
		super();
		this.postId = postId;
		this.title = title;
		this.image = image;
		this.recipe = recipe;
		this.ingredients = ingredients;
		this.postCategory = postCategory;
		this.postUser = postUser;
		this.postYtLink = postYtLink;
		this.postComment = postComment;
		this.postLike = postLike;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", image=" + image + ", recipe=" + recipe
				+ ", ingredients=" + ingredients + ", postCategory=" + postCategory + ", postUser=" + postUser
				+ ", postYtLink=" + postYtLink + ", postComment=" + postComment + ", postLike=" + postLike + "]";
	}

}