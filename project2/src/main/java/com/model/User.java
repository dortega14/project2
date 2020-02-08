package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne(mappedBy = "profileId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Profile> profile;

	@OneToMany(mappedBy = "commentId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> userComment;
	
	@OneToMany(mappedBy = "likeId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

	public Set<Profile> getProfile() {
		return profile;
	}

	public void setProfile(Set<Profile> profile) {
		this.profile = profile;
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

	public User(int userId, String username, String password, String firstName, String lastName, String email,
			Set<Profile> profile, Set<Comment> userComment, Set<Like> userLike) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.profile = profile;
		this.userComment = userComment;
		this.userLike = userLike;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", profile=" + profile + ", userComment="
				+ userComment + ", userLike=" + userLike + "]";
	}
	
	
}
