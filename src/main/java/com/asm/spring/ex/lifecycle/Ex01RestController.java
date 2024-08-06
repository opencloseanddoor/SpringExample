package com.asm.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 해당 클래스의 모든 메소드는 ResponseBody가 적용이 된다.
@RestController // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController
{
	// 직접 만든 클래스 객체 리턴
	@RequestMapping("3")
	public Person objectResponse()
	{
		Person me = new Person("김인규", 29);
		
		return me;
	}
	
	//status code 전달
	//status 코드를 지정한다
	@RequestMapping("4")
	public ResponseEntity<Person> entityResponse()
	{
		Person me = new Person("김인규", 30);
		
		// HTTP Status Code 필수적으로 알아야 하는 것들 
		// 200 OK 문제없음 정상적인 경우
		// 404 NOT FOUND : 페이지가 없다 (주소 확인) 페이지가 없는 경우
		// 400 BAD REQUEST : 요청이 잘못 되었다. (파라미터 일치 확인) 파라미터를 다시 전달을 하자
		// 405 METHOD NOT ALLOW : 메소드가 일치하지 않음 (get, post)
		// 500 INTERNAL SERVER ERROR : 서버 에러 (내 코드 확인) 코드가 잘못 된 경우에 뜬다.
		
		return new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR); //에러 코드 500이 뜬다.
	}
	
}