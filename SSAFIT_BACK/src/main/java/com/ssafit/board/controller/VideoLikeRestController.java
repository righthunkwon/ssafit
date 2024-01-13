package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.VideoLike;
import com.ssafit.board.model.service.VideoLikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Controller		: return 값이 뷰 페이지 이름
// @RestController 	: return 값이 데이터

@RestController
@RequestMapping("/api-video-like") // 공통으로 적용되는 상위 주소를 세팅
@Api(tags = "영상 좋아요 컨트롤러") // API의 이름 설정
// @CrossOrigin("*") -> WebConfig에서 설정
public class VideoLikeRestController {

	private VideoLikeService videoLikeService;

	@Autowired // 의존성 주입(생성자)
	public VideoLikeRestController(VideoLikeService videoLikeService) {
		this.videoLikeService = videoLikeService;
	}

	// 해당 영상에 대한 유저의 좋아요 조회
	@GetMapping("getLike")
	@ApiOperation(value = "해당 영상에 대한 유저의 좋아요 조회", notes = "해당 영상에 대한 유저의 좋아요 조회")
	public ResponseEntity<?> getLike(@RequestParam String userId, @RequestParam int videoId) {
		VideoLike videoLike = videoLikeService.getLike(userId, videoId);
		if (videoLike != null) { // 단축평가
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK); // 상태코드 200번
		} else {
			return new ResponseEntity<>("NO CONTENT", HttpStatus.NO_CONTENT); // 상태코드 204번
		}
	}

	// 해당 영상에 대한 전체 조회수 조회
	@GetMapping("getLikes")
	@ApiOperation(value = "해당 영상에 대한 유저의 좋아요 전체 수 조회", notes = "해당 영상에 대한 유저의 좋아요 전체 수 조회")
	public ResponseEntity<?> getLikes(@RequestParam int videoId) {
		List<VideoLike> list = videoLikeService.getLikes(videoId);
		if (list != null && list.size() >= 1) { // 단축평가
			return new ResponseEntity<>(list.size(), HttpStatus.OK); // 상태코드 200번
		} else {
			return new ResponseEntity<>("NO CONTENT", HttpStatus.NO_CONTENT); // 상태코드 204번
		}
	}

	// 좋아요
	@PostMapping("addLike")
	@ApiOperation(value = "영상 좋아요 기능", notes = "영상 좋아요 기능")
	public ResponseEntity<?> addLike(@RequestBody VideoLike videoLike) {
		String userId = videoLike.getUserId();
		int videoId = videoLike.getVideoId();
		int result = videoLikeService.addLike(userId, videoId);
		if (result == 1) {
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK); // 상태코드 200번
		} else {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST); // 상태코드 400번
		}
	}

	// 좋아요 취소
	@DeleteMapping("removeLike")
	@ApiOperation(value = "영상 좋아요 취소 기능", notes = "영상 좋아요 취소 기능")
	public ResponseEntity<?> removeLike(@RequestParam String userId, @RequestParam int videoId) {
		int result = videoLikeService.removeLike(userId, videoId);
		if (result == 1) {
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK); // 상태코드 200번
		} else {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST); // 상태코드 400번
		}
	}

}