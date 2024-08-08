package com.asm.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asm.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository
{
	//전달받은 id와 일치하는 행 조회
	public Review selectReview(@Param("id") int id);	
}
