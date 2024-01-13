package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Video;

public interface HomeService {

	// 조회수 순 상위 영상 조회(다섯 개)
	List<Video> getHomeVideoList();

}
