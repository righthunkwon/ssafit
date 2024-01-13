package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.VideoDao;
import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	private VideoDao videoDao;

	@Autowired // 의존성 주입: 생성자 주입(권장)
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	// 전체 비디오 조회
	@Override
	public List<Video> getList() {
		return videoDao.selectAll();
	}

	// ID에 해당하는 비디오 하나 조회
	@Override
	public Video getVideo(int videoId) {
		videoDao.updateViewCnt(videoId);
		return videoDao.selectOne(videoId);
	}

	// 비디오 등록
//	@Override
//	public int uploadVideo(Video video) {
//		return videoDao.insert(video);
//	}

	// 비디오 삭제
//	@Override
//	public int removeVideo(int videoId) {
//		return videoDao.deleteVideo(videoId);
//	}

	// 조회수 많은 순으로 비디오 조회
	@Override
	public List<Video> searchByHits() {
		return videoDao.selectByHits();
	}

	// 검색 조건 하 조회(글쓴이/제목/내용/운동부위)
	@Override
	public List<Video> searchByCondition(SearchCondition condition) {
		return videoDao.searchByCondition(condition);
	}

}


/*
 *  의존성 주입(@Autowired)
 *  1. 필드 주입
 *  @Autowired
 *  private VideoDao videoDao;

 *  2. 설정자 주입
 *  @Autowired
 *  public void setVideoDao(VideoDao videoDao) {
 *     this.videoDao = videoDao;
 *  }
 * 
 *  3. 생성자 주입(권장)
 *  @Autowired
 *  public VideoServiceImpl(VideoDao videoDao) {
 *     this.videoDao = videoDao;
 *  }
 */
