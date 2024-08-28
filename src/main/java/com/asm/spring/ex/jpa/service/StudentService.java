package com.asm.spring.ex.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.spring.ex.jpa.domain.Student;
import com.asm.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService
{
	/*
	 * 아래의 코드는 의존성 주입을 하는 부분이다, 의존성 주입을 인터페이스의
	 * 모든 메소드를 강제로 구현을 하지 않아도,
	 * 해당 인터페이스가 가지고있는 기능 중 필요한 기능만 가져올 수 있도록 하는 기능이다
	 */
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent
	(
			String name,
			String phoneNumber, 
			String email, 
			String dreamJob
	)
	{
		Student student = Student.builder()
		.name(name)
		.phoneNumber(phoneNumber)
		.email(email)
		.dreamJob(dreamJob).build();
		
		Student result = studentRepository.save(student);
		
		return result;
	}
}
