package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.VideoLike;

public interface VideoLikeService {

	// 해당 영상에 대한 유저의 좋아요 조회
	public VideoLike getLike(String userId, int videoId);

	// 해당 영상에 대한 전체 조회수 조회
	public List<VideoLike> getLikes(int videoId);

	// 좋아요
	public int addLike(String userId, int videoId);

	// 좋아요 취소
	public int removeLike(String userId, int videoId);

}
