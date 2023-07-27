package com.sns.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.like.dao.LikeToggleMapper;

@Service
public class LikeBO {
	
	@Autowired
	private LikeToggleMapper likeToggleMapper;
	// input: 누가, 어느글에
	// output: X
	
	public void LikeToggle(int postId, int userId) {
		// 셀렉트 => count(*)
		if (likeToggleMapper.selectLikeCountByPostIdOrUserId(postId, null) > 0) {
			// 삭제
			likeToggleMapper.deleteLikeByPostIdUserId(postId, userId);
		} else {
			// 추가
			likeToggleMapper.insertLike(postId, userId);
		}
	}
	
	// input: postId
	// output: 좋아요 개수(int)
	public int getLikeCountByPostId(int postId) {
		return likeToggleMapper.selectLikeCountByPostIdOrUserId(postId, null);
	}
	
	// input: postId, userId
	// output: 좋아요 여부 (boolean)
	public boolean filledLike(int postId, Integer userId) {
		// 비로그인
		if (userId == null) {
			return false;
		}
		
		// 로그인
		return likeToggleMapper.selectLikeCountByPostIdOrUserId(postId, userId)> 0;
	}
}
