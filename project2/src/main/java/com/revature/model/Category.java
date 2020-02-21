package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author TeamLeo
 * The category model contains the details
 * about the category of a post. It contains
 * the id and the category name.
 */
@Entity
@Table(name = "categories")
public class Category {
	
	/**
	 * Primary identifier for the post category.
	 */
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	/**
	 * Name of the post category.
	 */
	@Column(name = "category")
	private String category;
	
	/**
	 * Set for the categories
	 */
	@OneToMany(mappedBy = "postCategory",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Post> categoryPost;

	/**
	 * categoryId getter
	 * @return categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * categoryId setter
	 * @param categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * category name getter
	 * @return category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * category name setter
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * getter for a set of category posts
	 * @return categoryPost
	 */
	public Set<Post> getCategoryPost() {
		return categoryPost;
	}

	/**
	 * setter for a set of category posts
	 * @param categoryPost
	 */
	public void setCategoryPost(Set<Post> categoryPost) {
		this.categoryPost = categoryPost;
	}

	/**
	 * No-args constructor
	 */
	public Category() {
		super();
	}

	/**
	 * Category id and name constructor
	 * @param categoryId
	 * @param category
	 */
	public Category(int categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}
	
	/**
	 * Object constructor for Category
	 * @param categoryId
	 * @param category
	 * @param categoryPost
	 */
	public Category(int categoryId, String category, Set<Post> categoryPost) {
		super();
		this.categoryId = categoryId;
		this.category = category;
		this.categoryPost = categoryPost;
	}
	
	/**
	 * Category toString method
	 */
	@Override
	public String toString() {
		return "Category [category=" + this.category + "]";
	}

}
