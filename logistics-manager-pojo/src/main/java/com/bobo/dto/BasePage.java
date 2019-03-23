package com.bobo.dto;

/**
 * 封装分页的基本信息
 * 
 * @author 波波烤鸭
 *
 *         dengpbs@163.com
 */
public class BasePage {

	// 当前页
	protected int pageNum = 1;

	// 每页显示的条数
	protected int pageSize = 5;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
