package com.bobo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.mapper.RoleMapper;
import com.bobo.pojo.Role;
import com.bobo.pojo.RoleExample;
import com.bobo.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Resource
	private RoleMapper mapper;

	@Override
	public List<Role> query(Role role) {
		RoleExample example = new RoleExample();
		if(role !=null&& !"".equals(role.getRoleName()) && role.getRoleName()!=null){
			example.createCriteria().andRoleNameLike("%"+role.getRoleName()+"%");
		}
		
		return mapper.selectByExample(example);
	}

	@Override
	public void addRole(Role role) throws Exception {
		mapper.insertSelective(role);

	}

	@Override
	public void updateRole(Role role) throws Exception {
		mapper.updateByPrimaryKeySelective(role);

	}

	@Override
	public void deleteRole(int id) throws Exception {
		mapper.deleteByPrimaryKey(id);
	}

}
