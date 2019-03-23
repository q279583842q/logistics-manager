package com.bobo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bobo.dto.UserDto;
import com.bobo.mapper.UserMapper;
import com.bobo.pojo.Role;
import com.bobo.pojo.User;
import com.bobo.service.IRoleService;
import com.bobo.service.IUserService;
import com.github.pagehelper.PageInfo;

/**
 * 角色 控制层
 * @author 波波烤鸭
 *
 * dengpbs@163.com
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;

	@RequestMapping("/query")
	public String query(User user,Model model){
		List<User> list = userService.query(user);
		model.addAttribute("list", list);
		return "user/user";
	}
	
	@RequiresRoles("管理员")
	@RequestMapping("/queryPage")
	public String queryPage(UserDto dto,Model model){
		PageInfo<User> pageModel = userService.queryPage(dto);
		model.addAttribute("pageModel", pageModel);
		return "user/user";
	}
	
	
	
	/**
	 * 进入添加或者修改页面
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/userUpdate")
	public String userUpdatePage(Integer id,Model model) throws Exception{
		// 查询添加或者更新需要的数据
		userService.getUpdateUserInfo(id,model);
		return "/user/userUpdate";
	}
	
	/**
	 * 进入添加或者修改页面
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(UserDto userDto) throws Exception{
		userService.saveOrUpdate(userDto);
		return "redirect:/user/queryPage";
	}
	@RequestMapping("/delete")
	public String deleteUser(Integer id) throws Exception{
		userService.deleteUser(id);
		return "redirect:/user/queryPage";
	}
}
