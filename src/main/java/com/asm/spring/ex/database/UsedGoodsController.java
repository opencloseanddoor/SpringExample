package com.asm.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.spring.ex.database.domain.UsedGoods;
import com.asm.spring.ex.database.service.UsedGoodsService;

@Controller
public class UsedGoodsController
{
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	@RequestMapping("/db/usedGoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList()
	{
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodList();
		
		return usedGoodsList;
	}
}
