package com.revature.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@Column(name = "profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;

	@Column(name = "bio")
	private String bio;

	@Column(name = "cover_image")
	private Blob coverImage;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_user_id")
	@JsonIgnore
	private User profileUser;

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Blob getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(Blob coverImage) {
		this.coverImage = coverImage;
	}

	public User getUser() {
		return profileUser;
	}

	public void setUser(User user) {
		this.profileUser = user;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(int profileId, String bio, Blob coverImage, User user) {
		super();
		this.profileId = profileId;
		this.bio = bio;
		this.coverImage = coverImage;
		this.profileUser = user;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", bio=" + bio + ", coverImage=" + coverImage + ", user="
				+ profileUser + "]";
	}

}
