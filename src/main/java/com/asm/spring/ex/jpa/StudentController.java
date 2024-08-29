package com.asm.spring.ex.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.ex.jpa.domain.Student;
import com.asm.spring.ex.jpa.repository.StudentRepository;
import com.asm.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	//임시로 사용을 하는 형태
	// 절대로 Controller 에서는 Repository 객체를 다루면 안 된다!!!!!
	@Autowired
	private StudentRepository studentRepository;
	
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
	
	@GetMapping("/find")
	@ResponseBody
	public List<Student> findStudent()
	{
		// 모든 행 조회
		List<Student> studentList = null;
		
		//studentRepository.findAll();
		
		//studentList = studentRepository.findAllByOrderByIdDesc();
		
		//studentList = studentRepository.findTop2ByOrderByIdDesc();
		
		//studentList = studentRepository.findByName("유재석");
		
//		List<String> nameList = new ArrayList<>();
//		nameList.add("유재석");
//		nameList.add("조세호");
//		
//		studentList = studentRepository.findByNameIn(nameList);
		
		//studentList = studentRepository.findByEmailContaining("naver");
		//studentList = studentRepository.findByIdBetweenOrderByIdDesc(2, 3);
		
		studentList = studentRepository.selectByDreamJob("프로그래머");
		
		return studentList;
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