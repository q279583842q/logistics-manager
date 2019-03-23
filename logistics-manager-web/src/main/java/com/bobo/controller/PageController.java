package com.bobo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 页面控制器
 * @author 波波烤鸭
 *
 * dengpbs@163.com
 */
@Controller
public class PageController {

	/**
	 * 跟目录就跳转到login.jsp页面
	 * @return
	 */
	@RequestMapping("/")
	public String showMain(){
		return "login";
	}
	
	/**
	 * restful 风格
	 *    传递的是什么数据就跳转到对应的页面
	 * @param path
	 * @return
	 */
	@RequestMapping("/{path}")
	public String showTop(@PathVariable String path){
		return path;
	}
}
