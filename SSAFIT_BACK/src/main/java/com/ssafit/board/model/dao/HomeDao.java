package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Video;

public interface HomeDao {

	// 조회수 순 상위 영상 조회(다섯 개)
	public List<Video> selectByHits();
	
}
