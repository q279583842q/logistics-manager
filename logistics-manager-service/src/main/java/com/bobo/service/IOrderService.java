package com.bobo.service;

import org.springframework.ui.Model;

import com.bobo.dto.OrderDto;

public interface IOrderService {

	/**
	 * 查询添加订单或者修改订单需要查询的信息
	 * @param id
	 * @param m
	 */
	public void getUpdateInfo(Integer id,Model m);

	public void addOrder(OrderDto dto);
	
	
}
