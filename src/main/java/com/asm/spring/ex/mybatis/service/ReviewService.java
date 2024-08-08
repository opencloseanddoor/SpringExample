package com.asm.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.ex.mybatis.domain.Review;
import com.asm.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService 
{
	@Autowired
	private ReviewRepository reviewRepository;
	// 전달받은 id와 일치하는 리뷰 정보 리턴 기능
	public Review getReview(int id)
	{
		// review 테이블에서 id가 5인 행 조회
		Review review = reviewRepository.selectReview(id);
		
		return review;
	}
}
