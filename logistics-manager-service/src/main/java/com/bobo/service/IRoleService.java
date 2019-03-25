package com.bobo.service;

import java.util.List;

import com.bobo.pojo.Role;

/**
 * 角色
 * @author 波波烤鸭
 *
 * dengpbs@163.com
 */
public interface IRoleService {
	/**
	 * 根据条件查询角色
	 * @param role
	 * @return
	 */
	public List<Role> query(Role role);
	
	/**
	 * 添加角色信息
	 * @param role
	 * @throws Exception
	 */
	public void addRole(Role role) throws Exception;
	
	/**
	 * 根据id更新角色信息
	 * @param role
	 * @throws Exception
	 */
	public void updateRole(Role role) throws Exception;
	
	/**
	 * 根据id删除角色信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteRole(int id) throws Exception;
	
}
