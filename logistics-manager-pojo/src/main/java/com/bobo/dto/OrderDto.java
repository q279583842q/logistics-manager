package com.bobo.dto;

import java.util.List;

import com.bobo.pojo.Order;
import com.bobo.pojo.OrderDetail;

public class OrderDto extends Order{
	
	private List<OrderDetail> orderDetails;

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
