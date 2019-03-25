package com.bobo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bobo.dto.BasicDataDto;
import com.bobo.mapper.BasicDataMapper;
import com.bobo.pojo.BasicData;
import com.bobo.pojo.BasicDataExample;
import com.bobo.service.IBasicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BasicServiceImpl implements IBasicService {
	
	@Resource
	private BasicDataMapper basicDataMapper;

	@Override
	public List<BasicData> query(BasicData bd) {
		BasicDataExample example = new BasicDataExample();
		if(bd != null){
			if(!"".equals(bd.getBaseName()) && bd.getBaseName()!=null){
				// 根据 数据名称查询
				example.createCriteria().andBaseNameEqualTo(bd.getBaseName());
			}
		}
		return basicDataMapper.selectByExample(example );
	}

	@Override
	public PageInfo<BasicData> queryPage(BasicDataDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<BasicData> list = this.query(dto.getBasic());
		return new PageInfo<>(list);
	}

	@Override
	public void addBasicData(BasicData bd) {
		
		basicDataMapper.insertSelective(bd);
	}

	@Override
	public void deleteBasicData(int id) {
		basicDataMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateBasicData(BasicData bd) {
		basicDataMapper.updateByPrimaryKeySelective(bd);
	}

	@Override
	public void getUpdateInfo(Integer id, Model m) {
		BasicDataExample example = new BasicDataExample();
		example.createCriteria().andParentIdIsNull();
		// 查询所有的父类型
		List<BasicData> parents = basicDataMapper.selectByExample(example );
		m.addAttribute("parents", parents);
		if(id != null && id > 0){
			// 表示是更新数据，根据id查询出对应的数据信息
			BasicData data = basicDataMapper.selectByPrimaryKey(id);
			m.addAttribute("basic", data);
		}
	}

	@Override
	public List<BasicData> getBasicDataByParentName(String parentName) {
		BasicData bd = new BasicData();
		bd.setBaseName(parentName);
		// 根据 父编号名称查询出对应的 编号
		List<BasicData> list = this.query(bd);
		if(list!=null && list.size()==1){
			bd = list.get(0);
			// 然后根据baseID 查询所有对应的基础数据
			BasicDataExample example = new BasicDataExample();
			example.createCriteria().andParentIdEqualTo(bd.getBaseId());
			return basicDataMapper.selectByExample(example );
			
		}
		return null;
	}

}
