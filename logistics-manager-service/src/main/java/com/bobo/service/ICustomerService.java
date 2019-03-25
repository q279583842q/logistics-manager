package com.bobo.service;

import java.util.List;

import org.springframework.ui.Model;

import com.bobo.dto.CustomerDto;
import com.bobo.pojo.Customer;
import com.bobo.pojo.User;
import com.github.pagehelper.PageInfo;

public interface ICustomerService {

	/**
	 * 查询更新或者添加需要的信息
	 */
	public void getUpdateInfo(Integer id,Model m);

	public void addCustomer(Customer customer);

	/**
	 * 分页查询
	 * @param dto
	 * @return
	 */
	public PageInfo<CustomerDto> queryPage(CustomerDto dto,User user);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Integer id);
	
	public List<Customer> query(Customer customer);

	public Integer queryBaseIdByCustomerId(Integer customerId);
	
}
