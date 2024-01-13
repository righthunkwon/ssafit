package com.ssafit.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;
import com.ssafit.board.model.service.ReviewService;
import com.ssafit.board.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Controller		: return 값이 뷰 페이지 이름
// @RestController 	: return 값이 데이터

@RestController
@RequestMapping("/api-review") // 공통으로 적용되는 상위 주소를 세팅
@Api(tags = "리뷰 컨트롤러") // API의 이름 설정
// @CrossOrigin("*") // WebConfig에서 설정
public class ReviewRestController { // Board에 해당

	private ReviewService reviewService;
	private VideoService videoService;

	@Autowired // 의존성 주입(생성자)
	public ReviewRestController(ReviewService reviewService, VideoService videoService) {
		this.reviewService = reviewService;
		this.videoService = videoService;
	}

	// 후기 목록 출력
	@GetMapping("")
	@ApiOperation(value = "리뷰 목록 출력", notes = "")
	public ResponseEntity<List<Review>> showReviewList() {
		List<Review> reviewList = reviewService.showList();
		return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);
	}

	// 후기 상세보기
	@GetMapping("/{reviewId}")
	@ApiOperation(value = "리뷰 상세보기", notes = "리뷰 상세보기")
	public ResponseEntity<Object> reviewInfo(@PathVariable int reviewId) {
		Review review = reviewService.reviewInfo(reviewId);
		review.setViewcnt(review.getViewcnt() + 1);
		int videoId = review.getVideoId();
		Video video = videoService.getVideo(videoId);
		Map<Object, Object> responseMap = new HashMap<>();
		responseMap.put("review", review);
		responseMap.put("video", video);
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}

	// 후기 등록
	@PostMapping("")
	@ApiOperation(value = "리뷰 등록", notes = "리뷰 등록")
	public ResponseEntity<Integer> insertReview(@RequestBody Review review) {
		System.out.println(review.toString());
		int result = reviewService.insertReview(review);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	// 후기 삭제
	@DeleteMapping("/{reviewId}")
	@ApiOperation(value = "리뷰 삭제", notes = "리뷰 삭제")
	public ResponseEntity<Integer> deleteReview(@PathVariable int reviewId) {
		int result = reviewService.deleteReview(reviewId);
		if (result == 1) {
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} else if (result == 0) {
			return new ResponseEntity<Integer>(result, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Integer>(result, HttpStatus.BAD_REQUEST);
		}
	}

	// 후기 내용 수정
	@PutMapping("")
	@ApiOperation(value = "리뷰 내용 수정", notes = "리뷰 내용 수정")
	public ResponseEntity<Review> updateReview(@RequestBody Review review) {
		// RequestBody import 할 때 swagger가 아니라 spring framework에서 받아와야 한다.
		reviewService.updateReview(review);
		return new ResponseEntity<Review>(HttpStatus.OK);
	}

	// 검색
	@GetMapping("/search")
	@ApiOperation(value = "검색 조건 하 조회", notes = "리뷰 상세 검색(글쓴이/제목/내용)")
	public ResponseEntity<?> reviewSearch(SearchCondition condition) {
		List<Review> list = reviewService.searchByCondition(condition);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}

}