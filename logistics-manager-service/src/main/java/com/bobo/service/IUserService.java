package com.bobo.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.bobo.dto.UserDto;
import com.bobo.pojo.User;

/**
 * 用户信息
 * @author 波波烤鸭
 *
 * dengpbs@163.com
 */
public interface IUserService {

	/**
	 * 根据条件查询用户信息
	 * @param user
	 * @return
	 */
	public List<User> query(User user);
	
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * 修改用户
	 * @param user
	 * @throws Exception
	 */
	public void updateUser(User user)throws Exception;
	
	/**
	 * 删除用户
	 * @param id
	 * @throws Exception
	 */
	public void deleteUser(int id)throws Exception;

	/**
	 * 获取添加或者修改用户需要的数据
	 * 添加
	 *    获取所有的角色信息
	 * 修改
	 *    获取所有的角色信息及根据id查询的用户信息
	 * @param id
	 * @return
	 */
	public void getUpdateUserInfo(Integer id,Model model)throws Exception;

	/**
	 * 保存或修改用户数据
	 * @param userDto
	 */
	public void saveOrUpdate(UserDto userDto)throws Exception;
}
