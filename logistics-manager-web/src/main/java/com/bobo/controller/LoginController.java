package com.bobo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	/**
	 * 设定登录失败跳转的资源以及获取失败的信息
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(Model model, HttpServletRequest request) {
		Object ex = request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if (ex != null) {
			System.out.println(ex.toString() + "----------");
		}
		if (UnknownAccountException.class.getName().equals(ex)) {
			System.out.println("----账号不正确----->");
			model.addAttribute("msg", "账号不正确");
		} else if (IncorrectCredentialsException.class.getName().equals(ex)) {
			System.out.println("----密码不正确----->");
			model.addAttribute("msg", "密码不正确");
		} else {
			System.out.println("----其他错误----->");
			model.addAttribute("msg", "其他错误");
		}
		return "login";
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping("/logout.do")
	public String logout(){
		SecurityUtils.getSubject().logout();
		return "login";
	}
}
