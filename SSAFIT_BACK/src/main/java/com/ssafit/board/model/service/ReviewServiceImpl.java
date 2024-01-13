package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.ReviewDao;
import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.SearchCondition;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewDao reviewDao;

	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	// 후기 목록 조회
	@Override
	public List<Review> showList() {
		return reviewDao.selectAll();
	}

	// 후기 상세 조회
	@Override
	public Review reviewInfo(int reviewId) {
		reviewDao.updateViewCnt(reviewId);
		return reviewDao.selectOne(reviewId);
	}

	// 후기 등록
	@Override
	public int insertReview(Review review) {
		if (reviewDao.insert(review)) {
			return 0;
		}
		return 1;
	}

	// 후기 삭제
	@Override
	public int deleteReview(int reviewId) {
		if (reviewDao.delete(reviewId)) {
			return 1;
		}
		return 0;
	}

	// 후기 내용 수정
	@Override
	public void updateReview(Review review) {
		reviewDao.update(review);
	}

	// 후기 조회수 증가
	@Override
	public void cntup(int reviewId) {
		Review tmp = reviewDao.selectOne(reviewId);
		tmp.setViewcnt(tmp.getViewcnt() + 1);
		reviewDao.updateViewCnt(reviewId);
		return;
	}

	// 후기 조건 검색
	@Override
	public List<Review> searchByCondition(SearchCondition condition) {
		return reviewDao.selectByCondition(condition);
	}

}
