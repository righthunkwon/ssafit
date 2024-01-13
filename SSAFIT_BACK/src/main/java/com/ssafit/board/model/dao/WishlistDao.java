package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Wishlist;

public interface WishlistDao {

	// 찜 목록 하나 조회
	Wishlist selectOne(String userId, int videoId);

	// 전체 찜 목록 조회
	List<Wishlist> selectAll();

	// 찜 등록
	boolean insert(String userId, int videoId);

	// 찜 삭제
	boolean delete(String userId, int videoId);

}
