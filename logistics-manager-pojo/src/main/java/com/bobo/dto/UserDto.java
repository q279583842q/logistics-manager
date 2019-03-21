package com.bobo.dto;

import java.util.List;

import com.bobo.pojo.User;

/**
 * User传输对象
 * @author 波波烤鸭
 *
 * dengpbs@163.com
 */
public class UserDto {

	// 用户信息
	public User user;
	
	// 关联分配的角色信息
	public List<Integer> roles;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getRoles() {
		return roles;
	}

	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}
	
}
