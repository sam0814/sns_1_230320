package com.sns.post.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sns.post.entity.PostEntity;

@Repository
public interface PostMapper {

	public List<Map<String, Object>> selectPostList();
	
	public PostEntity selectPostByPostIdAndUserId(
			@Param("postId") int postId,
			@Param("userId") int userId);
}
