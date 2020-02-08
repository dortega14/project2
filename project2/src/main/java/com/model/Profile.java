package com.model;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne(mappedBy = "user_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private int userId;
		
	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Profile(int profileId, int userId, String bio, Blob coverImage) {
		super();
		this.profileId = profileId;
		this.userId = userId;
		this.bio = bio;
		this.coverImage = coverImage;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", userId=" + userId + ", bio=" + bio + ", coverImage=" + coverImage
				+ "]";
	}

}
