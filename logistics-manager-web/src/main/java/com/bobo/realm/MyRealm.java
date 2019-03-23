package com.bobo.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.bobo.pojo.Role;
import com.bobo.pojo.User;
import com.bobo.service.IUserService;
/**
 * 自定义的Realm
 * @author 波波烤鸭
 *
 * dengpbs@163.com
 */
public class MyRealm extends AuthorizingRealm{
	
	@Resource
	private IUserService userService;

	/**
	 * 认证的方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取提交的账号
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		// 获取登录的账号
		String userName = t.getUsername();
		System.out.println("---->"+userName);
		User user = new User();
		user.setUserName(userName);
		List<User> list = userService.query(user);
		if(list == null || list.size() > 1){
			// 账号不存在或者用户过多都返回null
			return null;
		}
		user = list.get(0);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),"bobo");
		return info;
	}
	
	/**
	 * 授权的方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取认证的信息
		User user = (User) principals.getPrimaryPrincipal();
		System.out.println("userId---->"+user.getUserId());
		// 获取登录用户对应的权限
		List<Role> roles = userService.queryRoleByUserId(user.getUserId());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if(roles !=null){
			System.out.println("权限个数:"+roles.size());
			for (Role role : roles) {
				// 将用户具有的角色保存到SimpleAuthorizationInfo对象中
				info.addRole(role.getRoleName());
			}
		}
		
		return info;
	}

}
