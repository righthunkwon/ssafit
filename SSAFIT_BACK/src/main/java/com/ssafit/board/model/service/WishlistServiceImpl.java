package com.ssafit.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.WishlistDao;
import com.ssafit.board.model.dto.Wishlist;

@Service
public class WishlistServiceImpl implements WishlistService {

	private WishlistDao wishlistDao;

	@Autowired
	public WishlistServiceImpl(WishlistDao wishlistDao) {
		this.wishlistDao = wishlistDao;
	}

	// 찜 등록
	@Override
	public Wishlist regist(String userId, int videoId) {
		Wishlist tmp = wishlistDao.selectOne(userId, videoId);
		if (tmp == null) {
			wishlistDao.insert(userId, videoId);
			return tmp;
		}
		return null;
	}

	// 찜 삭제
	@Override
	public Wishlist delete(String userId, int videoId) {
		Wishlist tmp = wishlistDao.selectOne(userId, videoId);
		if (tmp != null) {
			wishlistDao.delete(userId, videoId);
			return tmp;
		}
		return tmp;
	}

	// 해당 유저의 찜 목록 조회
	@Override
	public List<Wishlist> showWishlist(String userId) {
		List<Wishlist> list = new ArrayList<Wishlist>();
		List<Wishlist> origin = wishlistDao.selectAll();
		for (int i = 0; i < origin.size(); i++) {
			if (origin.get(i).getUserId().equals(userId)) {
				list.add(origin.get(i));
			}
		}
		return list;
	}

	// 전체 찜 목록 조회
	@Override
	public List<Wishlist> selectAllWishlist() {
		List<Wishlist> origin = wishlistDao.selectAll();
		return origin;
	}

}
