package com.model;

public class YouTubeLink {

	private int YouTubeId, postId;
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
