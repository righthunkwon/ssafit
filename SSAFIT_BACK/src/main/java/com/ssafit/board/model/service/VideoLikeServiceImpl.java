package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.VideoLikeDao;
import com.ssafit.board.model.dto.VideoLike;

@Service
public class VideoLikeServiceImpl implements VideoLikeService {

	private VideoLikeDao videoLikeDao;

	@Autowired
	public VideoLikeServiceImpl(VideoLikeDao videoLikeDao) {
		this.videoLikeDao = videoLikeDao;
	}

	// 해당 영상에 대한 유저의 좋아요 조회
	@Override
	public VideoLike getLike(String userId, int videoId) {
		return videoLikeDao.selectLike(userId, videoId);
	}

	// 해당 영상에 대한 전체 조회수 조회
	@Override
	public List<VideoLike> getLikes(int videoId) {
		return videoLikeDao.selectAllLike(videoId);
	}

	// 좋아요
	@Override
	public int addLike(String userId, int videoId) {
		int result = videoLikeDao.insertLike(userId, videoId);
		return result;
	}

	// 좋아요 취소
	@Override
	public int removeLike(String userId, int videoId) {
		int result = videoLikeDao.deleteLike(userId, videoId);
		return result;

	}

}
