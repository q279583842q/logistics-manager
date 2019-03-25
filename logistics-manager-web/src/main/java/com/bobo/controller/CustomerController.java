package com.bobo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bobo.dto.CustomerDto;
import com.bobo.pojo.Customer;
import com.bobo.pojo.User;
import com.bobo.service.ICustomerService;
import com.bobo.utils.Constant;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Resource
	private ICustomerService customerService;

	@RequestMapping("/customerUpdate")
	public String customerUpdate(Integer id,Model model){
		customerService.getUpdateInfo(id, model);
		return "customer/customerUpdate";
	}
	@RequestMapping("/query")
	public String query(CustomerDto dto,Model model){
		// 获取登录用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		System.out.println("--->"+user.getUserId());
		PageInfo<CustomerDto> list = customerService.queryPage(dto,user);
		model.addAttribute(Constant.PAGE_MODEL, list);
		return "customer/customer";
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(Customer customer) throws IOException{
		if(customer.getCustomerId()!=null && !"".equals(customer.getCustomerId())){
			// 更新
			customerService.updateCustomer(customer);
		}else{
			// 添加
			customerService.addCustomer(customer);
		}
		return "success";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) throws IOException{
		customerService.deleteCustomer(id);
		return "customer/query";
	}
	@RequestMapping("/queryBaseIdByCustomerId")
	@ResponseBody
	public Integer queryBaseIdByCustomerId(Integer customerId){
		Integer baseId = customerService.queryBaseIdByCustomerId(customerId);
		return baseId;
	}
}
