package com.asm.spring.ex.thymeleaf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController 
{
	@GetMapping("/ex01")
	public String ex01()
	{
		return "thymeleaf/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model)
	{
		// 과일 이름 리스트
		List<String> fruitList = new ArrayList<>();
		
		fruitList.add("사과");
		fruitList.add("귤");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList", fruitList); //객체를 전달합니다
		
		// "name":안성민, "age":29, "hobby":독서
		// "name":케인, "age":40, "hobby":사냥하기
		
		List<Map<String, Object>> userList = new ArrayList<>();
		
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("name", "안성민");
		userMap.put("age", 24);
		userMap.put("hobby", "독서");
		
		userList.add(userMap);
		
		userMap = new HashMap<>();
		
		userMap.put("name", "하늘");
		userMap.put("age", 40);
		userMap.put("hobby", "사냥하기");
		
		userList.add(userMap);
		
		model.addAttribute("userList", userList);
		
		return "thymeleaf/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model)
	{
		Date date = new Date();
		
		LocalDate localDate = LocalDate.now(); //static 메소드(객체 생성 없이 바로 사용가능안 메소드)
		LocalDateTime localDateTime = LocalDateTime.now();
		
		model.addAttribute("date", date);
		model.addAttribute("localDate", localDate);
		model.addAttribute("localDateTime", localDateTime);
		
		return "thymeleaf/ex03";
	}
}
