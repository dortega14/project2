package com.revature.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Set;

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

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author TeamLeo
 * This model contains the details for a
 * likable post created by a user. 
 */
@Entity
@Table(name = "posts")
public class Post {

	/**
	 * Primary key for post.
	 */
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	/**
	 * Name for post.
	 */
	@Column(name = "title")
	private String title;

	/**
	 * Timestamp for creation of post.
	 */
	@Column(name = "submitted")
	@CreationTimestamp
	private Timestamp postSubmitted;

	/**
	 * Image for post.
	 */
	@Column(name = "image")
	private Blob image;

	/**
	 * Recipe content for the post.
	 */
	@Column(name = "recipe")
	private String recipe;

	/**
	 * Ingredients for the recipe post.
	 */
	@Column(name = "ingredients")
	private String ingredients;

	/**
	 * Foreign key to like Post to Category.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_category_id")
	private Category postCategory;

	/**
	 * Foreign key to link Post to User.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_user_id")
	private User postUser;

	/**
	 * Foreign key to link Post to Youtube link.
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_yt_id")
	private YouTubeLink postYtLink;

	/**
	 * Foreign key to link  Post to Comment.
	 */
	@OneToMany(mappedBy = "commentPost", fetch = FetchType.EAGER)
	private Set<Comment> postComment;

	/**
	 * Foreign key to link Post to Like.
	 */
	@OneToMany(mappedBy = "likePost", fetch = FetchType.EAGER)
	private Set<Like> postLike;

	/**
	 * getter for postId.
	 * @return postId
	 */
	public int getPostId() {
		return postId;
	}

	/**
	 * setter for postId.
	 * @param postId
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}

	/**
	 * getter for post title.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * setter for post title.
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * getter for post submission.
	 * @return postSubmitted
	 */
	public Timestamp getPostSubmitted() {
		return postSubmitted;
	}

	/**
	 * setter for post submission.
	 * @param postSubmitted
	 */
	public void setPostSubmitted(Timestamp postSubmitted) {
		this.postSubmitted = postSubmitted;
	}

	/**
	 * getter for post image.
	 * @return image
	 */
	public Blob getImage() {
		return image;
	}
	
	/**
	 * setter for post image.
	 * @param image
	 */
	public void setImage(Blob image) {
		this.image = image;
	}

	/**
	 * getter for post recipe.
	 * @return recipe
	 */
	public String getRecipe() {
		return recipe;
	}

	/**
	 * setter for post recipe.
	 * @param recipe
	 */
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	/**
	 * getter for recipe ingredients.
	 * @return
	 */
	public String getIngredients() {
		return ingredients;
	}

	/**
	 * setter for recipe ingredients.
	 * @param ingredients
	 */
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * getter for postCategory.
	 * @return postCategory
	 */
	public Category getPostCategory() {
		return postCategory;
	}

	/**
	 * setter for post Category.
	 * @param postCategory
	 */
	public void setPostCategory(Category postCategory) {
		this.postCategory = postCategory;
	}

	/**
	 * getter for postUser.
	 * @return postUser
	 */
	public User getPostUser() {
		return postUser;
	}

	/**
	 * setter for postUser.
	 * @param postUser
	 */
	public void setPostUser(User postUser) {
		this.postUser = postUser;
	}

	/**
	 * getter for postYtLink.
	 * @return postYtLink
	 */
	public YouTubeLink getPostYtLink() {
		return postYtLink;
	}

	/**
	 * setter for postYtLink.
	 * @param postYtLink
	 */
	public void setPostYtLink(YouTubeLink postYtLink) {
		this.postYtLink = postYtLink;
	}

	/**
	 * setter for postComment.
	 * @return postComment
	 */
	public Set<Comment> getPostComment() {
		return postComment;
	}

	/**
	 * setter for postComment.
	 * @param postComment
	 */
	public void setPostComment(Set<Comment> postComment) {
		this.postComment = postComment;
	}

	/**
	 * getter for postLike.
	 * @return postLike
	 */
	public Set<Like> getPostLike() {
		return postLike;
	}

	/**
	 * setter for postLike.
	 * @param postLike
	 */
	public void setPostLike(Set<Like> postLike) {
		this.postLike = postLike;
	}

	/**
	 * Post no-args constructor.
	 */
	public Post() {
		super();
	}

	/**
	 * Post constructor by postId.
	 * @param postId
	 */
	public Post(int postId) {
		super();
		this.postId = postId;
	}

	/**
	 * Constructor without timestamp.
	 * @param postId
	 * @param title
	 * @param image
	 * @param recipe
	 * @param ingredients
	 * @param postCategory
	 * @param postUser
	 */
	public Post(int postId, String title, Blob image, String recipe, String ingredients, Category postCategory,
			User postUser) {
		super();
		this.postId = postId;
		this.title = title;
		this.image = image;
		this.recipe = recipe;
		this.ingredients = ingredients;
		this.postCategory = postCategory;
		this.postUser = postUser;
	}

	/**
	 * Constructor with timestamp.
	 * @param postId
	 * @param title
	 * @param postSubmitted
	 * @param image
	 * @param recipe
	 * @param ingredients
	 * @param postCategory
	 * @param postUser
	 */
	public Post(int postId, String title, Timestamp postSubmitted, Blob image, String recipe, String ingredients,
			Category postCategory, User postUser) {
		super();
		this.postId = postId;
		this.title = title;
		this.postSubmitted = postSubmitted;
		this.image = image;
		this.recipe = recipe;
		this.ingredients = ingredients;
		this.postCategory = postCategory;
		this.postUser = postUser;
	}

	/**
	 * Post object constructor.
	 * @param postId
	 * @param title
	 * @param image
	 * @param recipe
	 * @param ingredients
	 * @param postCategory
	 * @param postUser
	 * @param postYtLink
	 */
	public Post(int postId, String title, Blob image, String recipe, String ingredients, Category postCategory,
			User postUser, YouTubeLink postYtLink) {
		super();
		this.postId = postId;
		this.title = title;
		this.image = image;
		this.recipe = recipe;
		this.ingredients = ingredients;
		this.postCategory = postCategory;
		this.postUser = postUser;
		this.postYtLink = postYtLink;
	}

	/**
	 * Post toString method.
	 */
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", postSubmitted=" + postSubmitted + ", image=" + image
				+ ", recipe=" + recipe + ", ingredients=" + ingredients + ", postCategory=" + postCategory
				+ ", postUser=" + postUser + ", postYtLink=" + postYtLink + "]";
	}

}
