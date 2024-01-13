package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.User;

public interface UserService {

	// 전체 유저 조회
	List<User> selectAll();

	// 회원가입
	public int signUp(User user);

	// 로그인
	public User login(String id, String password);

	// 회원탈퇴
//	public int signOut(String id , String password);

	// 닉네임 변경
//	public int updateUser(String id, String nickname);

}
