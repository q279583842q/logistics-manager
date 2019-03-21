package com.bobo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bobo.pojo.Role;
import com.bobo.service.IRoleService;

/**
 * 角色 控制层
 * @author 波波烤鸭
 *
 * dengpbs@163.com
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private IRoleService roleService;

	@RequestMapping("/query")
	public String query(Role role,Model model){
		List<Role> list = roleService.query(role);
		model.addAttribute("list", list);
		return "role/role";
	}
}
