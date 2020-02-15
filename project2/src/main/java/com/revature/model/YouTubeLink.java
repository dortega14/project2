package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "yt_links")
public class YouTubeLink {

	@Id
	@Column(name = "yt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int youTubeId;

	@Column(name = "video_id")
	private String videoId;

	@Column(name = "start_time")
	private int startTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "yt_post_id")
	private Post ytPost;

	public int getYouTubeId() {
		return youTubeId;
	}

	public void setYouTubeId(int youTubeId) {
		this.youTubeId = youTubeId;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public Post getPost() {
		return ytPost;
	}

	public void setPost(Post post) {
		this.ytPost = post;
	}

	public YouTubeLink() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YouTubeLink(String videoId, int startTime, Post ytPost) {
		super();
		this.videoId = videoId;
		this.startTime = startTime;
		this.ytPost = ytPost;
	}

	public YouTubeLink(int youTubeId, String videoId, int startTime) {
		super();
		this.youTubeId = youTubeId;
		this.videoId = videoId;
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "YouTubeLink [youTubeId=" + youTubeId + ", videoId=" + videoId + ", startTime=" + startTime + "]";
	}

}
