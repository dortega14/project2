package com.revature.model;

import java.util.Set;

import javax.persistence.CascadeType;
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
 * The LikeType model contains the details
 * for the type of the like for a post.
 */
@Entity
@Table(name = "like_types")
public class LikeType {

	/**
	 * Primary key for likeType.
	 */
	@Id
	@Column(name = "like_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeTypeId;

	/**
	 * Name for the type of like.
	 */
	@Column(name = "like_type")
	private String likeType;

	/**
	 * Foreign key to link likeType to Like.
	 */
	@OneToMany(mappedBy = "likeLikeType", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Like> likeTypeLike;

	/**
	 * getter for likeTypeId.
	 * @return likeTypeId.
	 */
	public int getLikeTypeId() {
		return likeTypeId;
	}

	/**
	 * setter for likeTypeId.
	 * @param likeTypeId
	 */
	public void setLikeTypeId(int likeTypeId) {
		this.likeTypeId = likeTypeId;
	}

	/**
	 * getter for likeType.
	 * @return likeType
	 */
	public String getLikeType() {
		return likeType;
	}

	/**
	 * setter for likeType.
	 * @param likeType
	 */
	public void setLikeType(String likeType) {
		this.likeType = likeType;
	}

	/**
	 * getter for likeTypeLike.
	 * @return likeTypeLike
	 */
	public Set<Like> getLikeTypeLike() {
		return likeTypeLike;
	}

	/**
	 * setter for likeTypeLike.
	 * @param likeTypeLike
	 */
	public void setLikeTypeLike(Set<Like> likeTypeLike) {
		this.likeTypeLike = likeTypeLike;
	}

	/**
	 * No-args constructor for LikeType.
	 */
	public LikeType() {
		super();
	}

	/**
	 * LikeType constructor with likeTypeId and likeType params.
	 * @param likeTypeId
	 * @param likeType
	 */
	public LikeType(int likeTypeId, String likeType) {
		super();
		this.likeTypeId = likeTypeId;
		this.likeType = likeType;
	}

	/**
	 * LikeType object constructor.
	 * @param likeTypeId
	 * @param likeType
	 * @param likeTypeLike
	 */
	public LikeType(int likeTypeId, String likeType, Set<Like> likeTypeLike) {
		super();
		this.likeTypeId = likeTypeId;
		this.likeType = likeType;
		this.likeTypeLike = likeTypeLike;
	}

	/**
	 * LikeType toString method.
	 */
	@Override
	public String toString() {
		return "LikeType [likeTypeId=" + likeTypeId + ", likeType=" + likeType + "]";
	}

}
