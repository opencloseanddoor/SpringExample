package com.asm.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asm.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository 
{
	// 가장 최근에 조회된 행 조회
	public User selectLastUser();
	
	public int insertUser(
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email") String email
			, @Param("introduce") String introduce);
	
	public int insertUserByObject(User user);
}
