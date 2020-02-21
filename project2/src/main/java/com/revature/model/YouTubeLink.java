package com.revature.model;

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

/**
 * @author TeamLeo
 * The Youtube links model contains the details
 * for a Youtube video for a post.
 */
@Entity
@Table(name = "yt_links")
public class YouTubeLink {

	/**
	 * Unique identifier for the Youtube link.
	 */
	@Id
	@Column(name = "yt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int youTubeId;

	/**
	 * Youtube link.
	 */
	@Column(name = "video_id")
	private String videoId;

	/**
	 * Start time in the Youtube link.
	 */
	@Column(name = "start_time")
	private int startTime;

	/**
	 * Foreign key to link Youtube link to post.
	 */
	@OneToOne(mappedBy = "postYtLink", fetch = FetchType.EAGER)
	private Post ytPost;

	/**
	 * id for YouTube link.
	 * @return youTubeId
	 */
	public int getYouTubeId() {
		return youTubeId;
	}

	/**
	 * setter for youTubeId
	 * @param youTubeId
	 */
	public void setYouTubeId(int youTubeId) {
		this.youTubeId = youTubeId;
	}

	/**
	 * getter for videoId.
	 * @return videoId
	 */
	public String getVideoId() {
		return videoId;
	}

	/**
	 * setter for videoId.
	 * @param videoId
	 */
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	/**
	 * getter for startTime.
	 * @return
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * setter for startTime
	 * @param startTime
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	/**
	 * getter for ytPost.
	 * @return ytPost
	 */
	@JsonIgnore
	public Post getPost() {
		return ytPost;
	}

	/**
	 * setter for ytPost.
	 * @param post
	 */
	public void setPost(Post post) {
		this.ytPost = post;
	}
 
	/**
	 * YouTubeLink no-args constructor.
	 */
	public YouTubeLink() {
		super();
	}

	/**
	 * YouTubeLink object constructor with startTime.
	 * @param videoId
	 * @param startTime
	 * @param ytPost
	 */
	public YouTubeLink(String videoId, int startTime, Post ytPost) {
		super();
		this.videoId = videoId;
		this.startTime = startTime;
		this.ytPost = ytPost;
	}

	/**
	 * YouTubeLink object constructor.
	 * @param youTubeId
	 * @param videoId
	 * @param startTime
	 */
	public YouTubeLink(int youTubeId, String videoId, int startTime) {
		super();
		this.youTubeId = youTubeId;
		this.videoId = videoId;
		this.startTime = startTime;
	}

	/**
	 * YouTubeLink toString method.
	 */
	@Override
	public String toString() {
		return "YouTubeLink [youTubeId=" + youTubeId + ", videoId=" + videoId + ", startTime=" + startTime + "]";
	}

}
