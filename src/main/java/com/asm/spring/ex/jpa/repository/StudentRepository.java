package com.asm.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	// 1행 Insert
	// id(PK)를 기반으로 하나의 행을 조회하는 기능
	
	// id기준으로 내림차순 정렬된 결과 조회
	// ORDER BY `id` DESC
	List<Student> findAllByOrderByIdDesc();
	
	// id를 기준으로 내림차순한 결과
	// ORDER BY `id` DESC LIMIT 2
	public List<Student> findTop2ByOrderByIdDesc();
	
	// 전달 받은 이름과 일치하는 행 조회
	// WHERE `name` = #{name}
	public List<Student> findByName(String name);
	
	// 전달받은 이름들과 일치하는 행 조회
	// WHERE `name` IN (#{name}), #{name2})
	public List<Student> findByNameIn(List<String> nameList);
	
	// 전달 받은 값이 포함된 email 컬럼을 가진 행 조회
	//WHERE `email` LIKE `%gmail%'
	public List<Student> findByEmailContaining(String email);
	
	// id컬럼의 값이 특정 값 사이에 대응이 되는 행을 id기반으로 내림차순 정리 한 결과 조회
	//WHERE `id` BETWEEN 1 AND 5 ORDER BY `id` DESC
	public List<Student> findByIdBetweenOrderByIdDesc(int start, int end);
	
	// 쿼리를 직접 작성해서 실행
	// Native Query
	// draemJob 컬럼이 일치하는 데이터 조회
	@Query(value="SELECT * FROM `new_students` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<Student> selectByDreamJob(@Param("dreamJob") String draemJob);
	
}