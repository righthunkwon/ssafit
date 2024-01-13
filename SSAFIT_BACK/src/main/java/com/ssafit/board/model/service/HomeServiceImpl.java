package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.HomeDao;
import com.ssafit.board.model.dto.Video;

@Service
public class HomeServiceImpl implements HomeService {

	private HomeDao homeDao;

	@Autowired // 의존성 주입: 생성자 주입(권장)
	public HomeServiceImpl(HomeDao homeDao) {
		this.homeDao = homeDao;
	}

	@Override
	public List<Video> getHomeVideoList() {
		return homeDao.selectByHits();
	}

}
