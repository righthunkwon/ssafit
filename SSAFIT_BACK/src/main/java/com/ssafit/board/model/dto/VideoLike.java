package com.ssafit.board.model.dto;

public class VideoLike {
	private int videoLikeId;
	private String userId;
	private int videoId;

	public VideoLike() {

	}

	public VideoLike(int videoLikeId, String userId, int videoId) {
		this.videoLikeId = videoLikeId;
		this.userId = userId;
		this.videoId = videoId;
	}

	public int getVideoLikeId() {
		return videoLikeId;
	}

	public void setVideoLikeId(int videoLikeId) {
		this.videoLikeId = videoLikeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

}
