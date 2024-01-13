package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.Video;
import com.ssafit.board.model.service.HomeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Controller		: return 값이 뷰 페이지 이름
// @RestController 	: return 값이 데이터

@RestController
@RequestMapping("/api-home") // 공통으로 적용되는 상위 주소를 세팅
@Api(tags = "홈 컨트롤러") // API의 이름 설정
// @CrossOrigin("*") -> WebConfig에서 설정
public class HomeRestController {

	private HomeService homeService;

	@Autowired // 의존성 주입(생성자)
	public HomeRestController(HomeService homeService) {
		this.homeService = homeService;
	}

	// 조회수 순 영상 조회(상위 다섯 개)
	@GetMapping("")
	@ApiOperation(value = "조회수 순 영상 상위 다섯개 조회", notes = "조회수 순 영상 상위 다섯개 조회")
	public ResponseEntity<?> getVideoList() {
		List<Video> list = homeService.getHomeVideoList();
		if (list == null || list.size() == 0) { // 단축평가
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

}
