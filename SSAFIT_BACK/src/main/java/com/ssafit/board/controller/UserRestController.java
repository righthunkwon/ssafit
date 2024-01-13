package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.User;
import com.ssafit.board.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Controller		: return 값이 뷰 페이지 이름
// @RestController 	: return 값이 데이터

@RestController
@RequestMapping("/api-user") // 공통으로 적용되는 상위 주소를 세팅
@Api(tags = "유저 컨트롤러") // API의 이름 설정
// @CrossOrigin("*") -> WebConfig에서 설정
public class UserRestController {

	private UserService userService;

	@Autowired // 의존성 주입(생성자)
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	// 전체 유저 조회
	@GetMapping("user")
	@ApiOperation(value = "전체 유저 조회", notes = "전체 유저 조회")
	public ResponseEntity<?> selectAll() {
		try {
			List<User> list = userService.selectAll();
			if (list != null && list.size() > 0) {
				return new ResponseEntity<List<User>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 회원가입
	@PostMapping("signup")
	@ApiOperation(value = "유저 회원가입", notes = "유저 회원가입")
	public ResponseEntity<Integer> signup(@RequestBody User user) {
		boolean flag = true;
		String newUserId = user.getUserId();
		List<User> list = userService.selectAll();
		for (User u : list) {
			if (u.getUserId().equals(newUserId)) {
				flag = false;
				break;
			}
		}
		if (flag) {
			int result = userService.signUp(user);
			if (result == 1) {
				return new ResponseEntity<Integer>(result, HttpStatus.CREATED); // 201
			}
		}
		return new ResponseEntity<Integer>(HttpStatus.CONFLICT); // 409
	}

	// 로그인
	@PostMapping("login")
	@ApiOperation(value = "유저 로그인", notes = "유저 로그인")
	public ResponseEntity<?> login(@RequestBody User user) {
		User loginUser = userService.login(user.getUserId(), user.getPassword());

		// 로그인 실패 시 동작
		if (loginUser == null) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}

		// 로그인 성공 시 동작
		loginUser.setPassword("");
		return new ResponseEntity<User>(loginUser, HttpStatus.OK);
	}

}
