package com.asm.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.ex.jpa.domain.Student;
import com.asm.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jap/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	// C, U, D
	//안성민, 010-1234-5678, aaaddd@naver.com, 개발자
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent()
	{
		Student student = studentService.addStudent("김인규", "010-1111-1111", "assdf@naver.com", "개발자");
		
		return student;
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent()
	{
		//id가 3인 학생정보의 장래희망을 강사로 변경
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent()
	{
		// id가 4인 학생정보 삭제
		studentService.deleteStudent(4);
		
		return "삭제 완료";
	}
	
	
	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public Student lombokTest()
	{
		/*
		 * Student student = new Student(10, "안성민", "010-1111-2222",
		 * "sam1111@naver.com", "화이트해커", null, null);
		 * student.setPhoneNumber("010-1111-2222");
		 */
		
		Student student = 
				Student.builder()
				.name("안성민")
				.phoneNumber("010-1111-1111")
				.dreamJob("화이트 해커")
				.email("sss@naver.com").build();
		
		return student;	
	}
}