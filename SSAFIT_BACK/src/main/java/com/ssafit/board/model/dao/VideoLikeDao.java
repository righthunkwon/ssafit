package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.VideoLike;

public interface VideoLikeDao {

	// 해당 영상에 대한 유저의 좋아요 조회
	public VideoLike selectLike(String userId, int videoId);

	// 해당 영상에 대한 전체 조회수 조회
	public List<VideoLike> selectAllLike(int videoId);

	// 좋아요
	public int insertLike(String userId, int videoId);

	// 좋아요 취소
	public int deleteLike(String userId, int videoId);

}
