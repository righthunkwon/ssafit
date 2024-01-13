package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;

public interface ReviewService {

	// 후기 목록 조회
	public List<Review> showList();

	// 후기 상세 조회
	public Review reviewInfo(int reviewId);

	// 후기 등록
	public int insertReview(Review review);

	// 후기 삭제
	public int deleteReview(int reviewId);

	// 후기 내용 수정
	public void updateReview(Review review);

	// 후기 조회수 증가
	public void cntup(int reviewId);

	// 후기 조건 검색
	public List<Review> searchByCondition(SearchCondition condition);
	
}
