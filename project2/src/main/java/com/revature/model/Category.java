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


@Entity
@Table(name = "categories")
public class Category {

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;

	@Column(name = "category")
	private String category;

	@OneToMany(mappedBy = "postCategory",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Post> categoryPost;

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

	public Set<Post> getCategoryPost() {
		return categoryPost;
	}

	public void setCategoryPost(Set<Post> categoryPost) {
		this.categoryPost = categoryPost;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}

	public Category(int categoryId, String category, Set<Post> categoryPost) {
		super();
		this.categoryId = categoryId;
		this.category = category;
		this.categoryPost = categoryPost;
	}

	@Override
	public String toString() {
		return "Category [category=" + this.category + "]";
	}

}
