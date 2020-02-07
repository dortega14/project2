package com.model;

import java.sql.Blob;

public class Post {

	private int postId, category, userId;
	private String title, ingredients, recipe;
	private Blob image;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
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

	public Post(int postId, int category, int userId, String title, String ingredients, String recipe, Blob image) {
		super();
		this.postId = postId;
		this.category = category;
		this.userId = userId;
		this.title = title;
		this.ingredients = ingredients;
		this.recipe = recipe;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", category=" + category + ", userId=" + userId + ", title=" + title
				+ ", ingredients=" + ingredients + ", recipe=" + recipe + ", image=" + image + "]";
	}

}
