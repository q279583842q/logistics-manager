package com.bobo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bobo.dto.OrderDto;
import com.bobo.service.IOrderService;


@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private IOrderService orderService;
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Integer id,Model m){
		orderService.getUpdateInfo(id, m);
		return "order/orderUpdate";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String saveOrder(@RequestBody OrderDto dto){
		orderService.addOrder(dto);
		return "success";
	}
}
