package com.asm.spring.ex.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * 본 클래스에서 필요한 @(어노테이션)
 * @Builder //본 Entity클래스를 사용하는 부분에서 Builder()메소드를 사용을 할 수 있게 해준다
 * @NoArgsConstructor //매개변수가 필요없는 생성자를 만든다
 * @AllArgsConstructor //매개변수가 필요한 생성자를 만든다
 * @Getter //이 코드에서 선언한 변수에 1:1로 대응이 되는 Getter메소드를 만든다
 * @Table(name="new_students") //Database에서 name에서 대입을 받은 table을 얻어온다
 * @Entity /본 클래스를 Entity클래스로 사용이 되도록 한다
 */

@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="new_students")
@Entity
public class Student 
{
	@Id //기본키라는 것을 컴퓨터에게 알린다
	@GeneratedValue(strategy=GenerationType.IDENTITY) //기본키를 생성한다는 의미이다(기본키는 유일성을 준수해하한다)
	private int id;
	
	
	private String name;
	
	@Column(name="phoneNumber") //@Column어노테이션을 사용을 하는 이유는 카멜 기법을 사용을 하는 변수를 스네이크 기법을 사용하는 항목과 통일을 시키기 위해서 사용을 하는 어노테이션이다.
	private String phoneNumber;
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@CreationTimestamp //날짜를 사용자가 코드 내에서 작성을 하지 않아도 페이지에서 자동으로 표시가 되도록 하기 위해 사용하는 어노테이션이다.
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp //날짜를 사용자가 코드 내에서 작성을 하지 않아도 페이지에서 자동으로 표시가 되도록 하기 위해 사용하는 어노테이션이다.
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;
}