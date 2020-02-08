package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "yt_links")
public class YouTubeLink {

	@Id
	@Column(name = "yt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int YouTubeId; 
	
	
	private int postId;
	
	@Column(name = "link")
	private String link;

	public int getYouTubeId() {
		return YouTubeId;
	}

	public void setYouTubeId(int youTubeId) {
		YouTubeId = youTubeId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public YouTubeLink(int youTubeId, int postId, String link) {
		super();
		YouTubeId = youTubeId;
		this.postId = postId;
		this.link = link;
	}

	@Override
	public String toString() {
		return "YouTubeLink [YouTubeId=" + YouTubeId + ", postId=" + postId + ", link=" + link + "]";
	}

}
