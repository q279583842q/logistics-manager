package com.bobo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bobo.dto.OrderDto;
import com.bobo.mapper.OrderDetailMapper;
import com.bobo.mapper.OrderMapper;
import com.bobo.pojo.BasicData;
import com.bobo.pojo.Customer;
import com.bobo.pojo.OrderDetail;
import com.bobo.pojo.User;
import com.bobo.service.IBasicService;
import com.bobo.service.ICustomerService;
import com.bobo.service.IOrderService;
import com.bobo.service.IUserService;
import com.bobo.utils.Constant;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private OrderDetailMapper orderDetailMapper;
	@Resource
	private IUserService userService;
	@Resource
	private IBasicService basicService;
	@Resource
	private ICustomerService customerService;

	/**
	 * 新增订单需要查询的信息有
	 * 1.查询出所有的业务员
	 * 2.查询出所有的客户
	 * 3.查询基础数据
	 * 	   付款方式:BASIC_PAYMENT_TYPE
	 *   货运方式:BASIC_FREIGHT_TYPE
	 *   取件方式:BASIC_FETCH_TYPE
	 *   常用区间:BASIC_COMMON_INTERVAL
	 *   国家：Constant.BASIC_COMMON_INTERVAL
	 *   单位：Constant.BASIC_UNIT
	 */
	@Override
	public void getUpdateInfo(Integer id, Model m) {
		// 1.查询所有具有业务员角色的用户信息
		List<User> users = userService.queryUserByRoleName(Constant.ROLE_SALESMAN);
		// 2.查询 常用区间的基础数据
		List<BasicData> intervals = basicService.getBasicDataByParentName(Constant.BASIC_COMMON_INTERVAL);
		// 3.付款方式
		List<BasicData> payments = basicService.getBasicDataByParentName(Constant.BASIC_PAYMENT_TYPE);
		// 4.货运方式
		List<BasicData> freights = basicService.getBasicDataByParentName(Constant.BASIC_FREIGHT_TYPE);
		// 5.取件方式
		List<BasicData> fetchs = basicService.getBasicDataByParentName(Constant.BASIC_FETCH_TYPE);
		// 6.查询客户信息
		List<Customer> customers = customerService.query(null);
		// 7.国家
		List<BasicData> countrys = basicService.getBasicDataByParentName(Constant.BASIC_COMMON_INTERVAL);
		// 8.单位
		List<BasicData> units = basicService.getBasicDataByParentName(Constant.BASIC_UNIT);
		m.addAttribute("users", users);
		m.addAttribute("intervals", intervals);
		m.addAttribute("payments", payments);
		m.addAttribute("freights", freights);
		m.addAttribute("fetchs", fetchs);
		m.addAttribute("customers", customers);
		m.addAttribute("countrys", countrys);
		m.addAttribute("units", units);
	}

	@Override
	public void addOrder(OrderDto dto) {
		orderMapper.insertSelective(dto);
		// 添加订单主表 获取生成的key
		List<OrderDetail> details = dto.getOrderDetails();
		if(details !=null && details.size() > 0 ){
			for (OrderDetail orderDetail : details) {
				// 详情关联订单编号
				orderDetail.setOrderId(dto.getOrderId());
				// 保存详情数据
				orderDetailMapper.insertSelective(orderDetail);
			}
		}
	}

}
