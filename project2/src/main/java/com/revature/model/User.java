package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@OneToOne(mappedBy = "profileUser", fetch = FetchType.EAGER)
	private Profile profile;

	@OneToMany(mappedBy = "postUser", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Post> userPost;

	@OneToMany(mappedBy = "commentUser", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Comment> userComment;

	@OneToMany(mappedBy = "likeUser", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Like> userLike;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Post> getUserPost() {
		return userPost;
	}

	public void setUserPost(Set<Post> userPost) {
		this.userPost = userPost;
	}

	public Set<Comment> getUserComment() {
		return userComment;
	}

	public void setUserComment(Set<Comment> userComment) {
		this.userComment = userComment;
	}

	public Set<Like> getUserLike() {
		return userLike;
	}

	public void setUserLike(Set<Like> userLike) {
		this.userLike = userLike;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String username, String password, String firstName, String lastName, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

//	public User(int userId, String username, String password, String firstName, String lastName, String email,
//			Profile profile, Set<Comment> userComment, Set<Like> userLike) {
//		super();
//		this.userId = userId;
//		this.username = username;
//		this.password = password;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.profile = profile;
//		this.userComment = userComment;
//		this.userLike = userLike;
//	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
