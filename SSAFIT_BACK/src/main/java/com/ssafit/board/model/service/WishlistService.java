package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Wishlist;

public interface WishlistService {

	// 찜 등록
	public Wishlist regist(String userId, int videoId);

	// 찜 삭제
	public Wishlist delete(String userId, int videoId);

	// 해당 유저의 찜 목록 조회
	public List<Wishlist> showWishlist(String userId);

	// 전체 찜 목록 조회
	public List<Wishlist> selectAllWishlist();
	
}
