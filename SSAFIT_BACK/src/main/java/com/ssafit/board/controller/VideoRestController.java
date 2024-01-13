package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;
import com.ssafit.board.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Controller		: return 값이 뷰 페이지 이름
// @RestController 	: return 값이 데이터

@RestController
@RequestMapping("/api-video") // 공통으로 적용되는 상위 주소를 세팅
@Api(tags = "비디오 컨트롤러") // API의 이름 설정
// @CrossOrigin("*") -> WebConfig에서 설정
public class VideoRestController {

	private VideoService videoService;

	@Autowired // 의존성 주입(생성자)
	public VideoRestController(VideoService videoService) {
		this.videoService = videoService;
	}

	// 전체 비디오 조회
	@GetMapping("")
	@ApiOperation(value = "비디오 조회", notes = "전체 비디오 조회")
	public ResponseEntity<?> getVideoList() {
		List<Video> list = videoService.getList();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

	// ID에 해당하는 비디오 하나 조회
	@GetMapping("/{id}")
	@ApiOperation(value = "비디오 상세 조회", notes = "상세 비디오 조회")
	public ResponseEntity<Video> detail(@PathVariable int id) {
		Video video = videoService.getVideo(id);
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}

	// 비디오 등록
//	@PostMapping("/video")
//	@ApiOperation(value="비디오 등록", notes="비디오 등록")
//	public ResponseEntity<Video> write(Video video){
//		videoService.uploadVideo(video);
//		return new ResponseEntity<Video>(video, HttpStatus.CREATED);
//	}

	// 비디오 삭제
//	@DeleteMapping("/video/{videoId}")
//	@ApiOperation(value="비디오 삭제", notes="비디오 삭제")
//	public ResponseEntity<Integer> delete(@PathVariable int videoId){
//		int result = videoService.removeVideo(videoId);
//		if (result == 1) {
//			return new ResponseEntity<Integer>(result, HttpStatus.OK);
//		} else if (result == 0) {
//			return new ResponseEntity<Integer>(result, HttpStatus.NO_CONTENT);
//		} else {
//			return new ResponseEntity<Integer>(result, HttpStatus.BAD_REQUEST);
//		}
//	}

	// 조회수 많은 순으로 비디오 조회
	@GetMapping("/video-hits")
	@ApiOperation(value = "비디오 조회수 순 조회", notes = "비디오 조회수 순 내림차순 조회")
	public ResponseEntity<?> listByHits() {
		List<Video> list = videoService.searchByHits();
		if (list == null || list.size() == 0) { // 단축평가
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

	// 검색 조건 하 조회(글쓴이/제목/내용/운동부위)
	@GetMapping("/search")
	@ApiOperation(value = "검색 조건 하 조회", notes = "영상 검색 조건 하 조회(글쓴이/제목/내용/운동부위)")
	public ResponseEntity<?> searchByCondition(SearchCondition condition) {
		List<Video> list = videoService.searchByCondition(condition);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

}
