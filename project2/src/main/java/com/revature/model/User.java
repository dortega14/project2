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

/**
 * @author TeamLeo
 * The User model contains the details of the user.
 */
@Entity
@Table(name = "users")
public class User {

	/**
	 * Unique Identifier for User.
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	/**
	 * username for user.
	 */
	@Column(name = "username", unique = true)
	private String username;

	/**
	 * password for user.
	 */
	@Column(name = "password")
	private String password;

	/**
	 * First name of the user.
	 */
	@Column(name = "first_name")
	private String firstName;

	/**
	 * Last name of the user.
	 */
	@Column(name = "last_name")
	private String lastName;

	/**
	 * Email of the user.
	 */
	@Column(name = "email")
	private String email;

	/**
	 * Foreign key to link User to Profile.
	 */
	@OneToOne(mappedBy = "profileUser", fetch = FetchType.EAGER)
	@JsonIgnore
	private Profile profile;

	/**
	 * Foreign key to link User to Post.
	 */
	@OneToMany(mappedBy = "postUser", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Post> userPost;

	/**
	 * Foreign key to link User to Comment.
	 */
	@OneToMany(mappedBy = "commentUser", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Comment> userComment;

	/**
	 * Foreign key to link User to Like.
	 */
	@OneToMany(mappedBy = "likeUser", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Like> userLike;

	/**
	 * getter for userId.
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * setter for userId.
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * getter for username.
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * setter for username.
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getter for password.
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter for password.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getter for firstName.
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * setter for firstName.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * getter for lastName.
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * setter for lastName.
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * getter for email.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setter for email.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getter for profile.
	 * @return profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * setter for profile.
	 * @param profile
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * getter for userPost.
	 * @return userPost
	 */
	public Set<Post> getUserPost() {
		return userPost;
	}

	/**
	 * setter for userPost.
	 * @param userPost
	 */
	public void setUserPost(Set<Post> userPost) {
		this.userPost = userPost;
	}

	/**
	 * setter for userComment.
	 * @return userComment.
	 */
	public Set<Comment> getUserComment() {
		return userComment;
	}

	/**
	 * setter for a set of userComment.
	 * @param userComment
	 */
	public void setUserComment(Set<Comment> userComment) {
		this.userComment = userComment;
	}

	/**
	 * getter for userLike.
	 * @return userLike
	 */
	public Set<Like> getUserLike() {
		return userLike;
	}

	/**
	 * setter for userLike.
	 * @param userLike
	 */
	public void setUserLike(Set<Like> userLike) {
		this.userLike = userLike;
	}

	/**
	 * User no-args constructor.
	 */
	public User() {
		super();
	}

	/**
	 * User object constructor.
	 * @param userId
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
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

	/**
	 * User toString method.
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
