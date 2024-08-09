package com.asm.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.ex.mybatis.domain.Review;
import com.asm.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/store")
public class ReviewController 
{
	@Autowired
	private ReviewService reviewService;
	
	//parameter로 전달받은 id와 일치하는 리뷰 정보를 json으로 reponse 담는다.
	@RequestMapping("/mybatis/store/review")
	@ResponseBody
	// id가 5인 리뷰 정보를 json으로 Response를 담는다.
	public Review review(@RequestParam("id") int id)
	{
		//request parameter
		//request.getParameter("id");
		Review review = reviewService.getReview(id);
		
		return review;
	}
	
	//리뷰정보를 저장하는 페이지
	@RequestMapping("/create")
	@ResponseBody
	public String createReview()
	{
		//4, 치즈피자, 김인규, 4.5, 치즈피자 존맛!
		//int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛");
		
		//2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리 입니다.
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다");
		
		int count = reviewService.addReviewByObject(review);
		//입력 갯수 : 1
		return "입력 갯수 : " + count;
	}
}
