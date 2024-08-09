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
	// 리뷰에 저장을 할 값들을 전달을 받고, 리뷰 저장 기능
	public int addReview(int storeId
			, String menu
			, String userName
			, double point
			, String review)
	{
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		
		return count;
	}
	//리뷰에 저장을 할 값들을 객체로 전달을 받고, 리뷰 저장 기능
	public int addReviewByObject(Review review)
	{
		int count = reviewRepository.insertByReviewObject(review);
		return count;
	}
}
