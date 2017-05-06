package com.java1234.shiro;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.java1234.common.ShiroUtil;

public class PermissionTest {

	@Test
	public void testIsPermitted() {
		Subject currentUser = ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "123456");
		System.out.println("是否有user：select这个权限：" + currentUser.isPermitted("user:select"));
		currentUser.isPermitted("user:select", "user:update");// 返回boolean的数组
		currentUser.isPermittedAll("user:select", "user:update");// 如果都有返回true，任何一个没有就返回false
		currentUser.logout();
	}

	@Test
	public void testCheckPermitted() {
		Subject currentUser = ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "123456");
		currentUser.checkPermission("user:select");
		currentUser.checkPermissions("user:select", "user:update");
		currentUser.logout();
	}
}
