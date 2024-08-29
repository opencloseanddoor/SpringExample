package com.asm.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.spring.ex.jpa.domain.Student;

/*
 * 본 코드에서 사용을 하는 코드들
 * interface 클래스에게 메소드의 강제 구현 또는 다형성을 제공한는 자바의 기능이다
 * extends 다른 클래스를 상속을 받음으로서 다른 클래스에 기능을 물려받게 되는 기능이다
 * JpaRepository<Student, Integer>는 Jpa의 기능으로서 xml파일을 통해서 직접 쿼리를 수행을 하지 않아도 
 * JpaRepository안에 있는 메소드를 통해서 쿼리를 수행을 하도록 도와주는 클래스이다
 * 그리고 제네릭스는 Entity클래스와 Wraper클래스를 필요로한다. 
 */

public interface StudentRepository extends JpaRepository<Student, Integer>
{
	//1행 Insert
	// id(PK)를 기반으로 하나의 행을 조회하는 기능
	
}