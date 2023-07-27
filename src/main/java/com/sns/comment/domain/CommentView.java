package com.sns.comment.domain;

import java.util.List;

import com.sns.user.entity.UserEntity;

import lombok.Data;

// 댓글 하나. comment와 1:1 매핑
@Data
public class CommentView {
	// 댓글 하나
	private Comment comment;
	
	// 댓글쓴이
	private UserEntity user;
	
	// 댓글들
	private List<CommentView> commentList;
	
	// 좋아요들 개수
	private int likeCount;
	
	//내가 좋아요 눌렀는지 여부
	private boolean isFilled;
	
}
