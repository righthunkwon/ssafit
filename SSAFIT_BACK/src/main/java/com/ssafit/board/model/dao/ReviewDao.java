package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.SearchCondition;

public interface ReviewDao {

	// 후기 목록 조회
	List<Review> selectAll();

	// 후기 하나 조회
	Review selectOne(int reviewId);

	// 후기 등록
	boolean insert(Review review);

	// 후기 삭제
	boolean delete(int reviewId);

	// 후기 내용 수정
	boolean update(Review review);

	// 후기 조회수 증가
	public void updateViewCnt(int id);

	// 조건에 따른 후기검색
	public List<Review> selectByCondition(SearchCondition condition);

}
