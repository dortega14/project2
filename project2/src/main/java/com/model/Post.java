package com.model;

import java.sql.Blob;

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

	@OneToOne(mappedBy ="category_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Categories category;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private int userId;

	
	private int linkId;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public Post(int postId, String title, Blob image, String recipe, String ingredients, Categories category, int userId,
			int linkId) {
		super();
		this.postId = postId;
		this.title = title;
		this.image = image;
		this.recipe = recipe;
		this.ingredients = ingredients;
		this.category = category;
		this.userId = userId;
		this.linkId = linkId;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", image=" + image + ", recipe=" + recipe
				+ ", ingredients=" + ingredients + ", category=" + category + ", userId=" + userId + ", linkId="
				+ linkId + "]";
	}

}
