package com.model;

public class Categories {

	private int categoryId;
	private String category;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Categories(int categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Categories [categoryId=" + categoryId + ", category=" + category + "]";
	}

}
