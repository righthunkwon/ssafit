package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.User;

public interface UserDao {
	
	// 전체 유저 조회
	List<User> selectAll();
	
	// id와 일치하는 유저 조회
	public User selectOne(String id);
	
	// 회원가입
	public int insertUser(User user);
	
	// 회원탈퇴
//	public int deleteUser(String id, String password);
	
	// 회원정보수정(닉네임)
//	public int updateUser(String id,String nickname);

}
