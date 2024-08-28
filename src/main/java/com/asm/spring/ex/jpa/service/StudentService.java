package com.asm.spring.ex.jpa.service;

import java.util.Optional;

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
	
	// id와 장래희망을 전달 받고, 수정하는 기능
	public Student updateStudent(int id, String dreamJob)
	{
		// update 대상을 조회 한다.
		// 조회된 객체에서 수정을 진행한다.
		// 해당 객체를 저장한다.
		
		// Optional
		// null 일수도 있는 객체를 처리할때 사용하는 객체(null exception은 매우 위험)
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		Student student = optionalStudent.orElse(null);
		
		student = student.toBuilder().dreamJob(dreamJob).build();
		
		Student result = studentRepository.save(student);
		
		return result;
	
	}
	
	public void deleteStudent(int id)
	{
		// 삭제 대상을 조회 한다.
		// 조회된 객체를 통해서 삭제를 한다.
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
	}
}
