package com.java1234.shiro;

import java.util.Arrays;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.java1234.common.ShiroUtil;

public class RoleTest {

	@Test
	public void testHasRole() {
		Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "java1234", "123456");
		System.out.println(currentUser.hasRole("role1") ? "有role1这个角色" : "没有role1这个角色");
		boolean[] results = currentUser.hasRoles(Arrays.asList("role1", "role2", "role3"));
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i] ? ("有role" + (i + 1) + "这个角色") : ("没有role" + (i + 1) + "这个角色"));
		}
		System.out.println(currentUser.hasAllRoles(Arrays.asList("role1", "role2")) ? "有" : "没有");
		currentUser.logout();
	}

	@Test
	public void testCheckRole() {
		Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "java1234", "123456");
		try {
			// currentUser.checkRole("role3");
			// currentUser.checkRoles(Arrays.asList("role1", "role3"));
			// currentUser.checkRoles("role1", "role3");
			System.out.println("有角色");
		} catch (AuthorizationException e) {
			System.out.println("没有这个角色");
			e.printStackTrace();
		}

		currentUser.logout();
	}

}
