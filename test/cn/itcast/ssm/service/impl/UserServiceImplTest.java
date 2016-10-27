package cn.itcast.ssm.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.ssm.po.User;
import cn.itcast.ssm.service.UserService;

public class UserServiceImplTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {

		applicationContext = new ClassPathXmlApplicationContext(new String[] {
				"spring/applicationContext.xml",
				"spring/applicationContext-dao.xml",
				"spring/applicationContext-service.xml"

		});
	}

	@Test
	public void testFindUserById() throws Exception {
		
		UserService userService = (UserService) applicationContext.getBean("userService");
		
		User user = userService.findUserById(10);
		System.out.println(user);
	}
	//测试事务
	@Test
	public void testSaveUser() throws Exception {
		
		UserService userService = (UserService) applicationContext.getBean("userService");
		
		userService.saveUser();
	}

}
