package com.asm.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.asm.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository 
{
	// 가장 최근에 조회된 행 조회
	public User selectLastUser();
}
