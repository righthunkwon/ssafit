package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;

public interface VideoService {

	// 전체 비디오 조회
	List<Video> getList();

	// ID에 해당하는 비디오 하나 조회
	Video getVideo(int videoId);

	// 비디오 등록
//	int uploadVideo(Video video);

	// 비디오 삭제
//	int removeVideo(int videoId);

	// 조회수 많은 순으로 비디오 조회
	List<Video> searchByHits();

	// 검색 조건 하 조회(글쓴이/제목/내용/운동부위)
	List<Video> searchByCondition(SearchCondition condition);

}