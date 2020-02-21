package com.revature.model;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author TeamLeo
 * This model contains detail about the 
 * profile of a user.
 */
@Entity
@Table(name = "profile")
public class Profile {

	/**
	 * Unique identifier for user.
	 */
	@Id
	@Column(name = "profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;

	/**
	 * Bio details for the user's profile.
	 */
	@Column(name = "bio")
	private String bio;

	/**
	 * Cover image for the profile of the user.
	 */
	@Column(name = "cover_image")
	private Blob coverImage;

	/**
	 * Foreign key to link profile to user.
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_user_id")
	private User profileUser;

	/**
	 * getter for profileId.
	 * @return profileId
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * setter for profileId.
	 * @param profileId
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	/**
	 * getter for profile bio.
	 * @return bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * setter for profile bio.
	 * @param bio
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * getter for coverImage.
	 * @return coverImage
	 */
	public Blob getCoverImage() {
		return coverImage;
	}

	/**
	 * setter for coverImage.
	 * @param coverImage
	 */
	public void setCoverImage(Blob coverImage) {
		this.coverImage = coverImage;
	}

	/**
	 * getter for profileUser.
	 * @return profileUser
	 */
	public User getUser() {
		return profileUser;
	}

	/**
	 * setter for profileUser.
	 * @param user
	 */
	public void setUser(User user) {
		this.profileUser = user;
	}

	/**
	 * Profile no-args constructor.
	 */
	public Profile() {
		super();
	}

	/**
	 * Profile object constructor.
	 * @param profileId
	 * @param bio
	 * @param coverImage
	 * @param user
	 */
	public Profile(int profileId, String bio, Blob coverImage, User user) {
		super();
		this.profileId = profileId;
		this.bio = bio;
		this.coverImage = coverImage;
		this.profileUser = user;
	}

	/**
	 * Profile toString() method.
	 */
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", bio=" + bio + ", coverImage=" + coverImage + ", user="
				+ profileUser + "]";
	}

}
