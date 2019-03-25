package com.bobo.dto;

import com.bobo.pojo.Customer;
/**
 * 客户的数据传输对象
 * 
 * @author 波波烤鸭
 *
 * dengpbs@163.com
 */
public class CustomerDto extends BasePage{
	
	private Customer customer;
	
	// 业务员
	private String salesMan;
	
	// 常用区间
	private String interval;
	
	// 订单个数
	private Integer orderNum;

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSalesMan() {
		return salesMan;
	}

	public void setSalesMan(String salesMan) {
		this.salesMan = salesMan;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	
}
