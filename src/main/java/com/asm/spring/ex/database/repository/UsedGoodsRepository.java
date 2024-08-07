package com.asm.spring.ex.database.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asm.spring.ex.database.domain.UsedGoods;

//데이터베이스 관련 처리
//쿼리 수행
@Mapper
public interface UsedGoodsRepository
{
	// usedGoods모든 행 조회
	public List<UsedGoods> selectedUsedGoodsList();
}
