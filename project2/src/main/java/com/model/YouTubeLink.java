package com.model;

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

	@Column(name = "link")
	private String link;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "yt_post_id")
	private Post ytPost;

	public int getYouTubeId() {
		return youTubeId;
	}

	public void setYouTubeId(int youTubeId) {
		this.youTubeId = youTubeId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Post getPost() {
		return ytPost;
	}

	public void setPost(Post post) {
		this.ytPost = post;
	}

}
