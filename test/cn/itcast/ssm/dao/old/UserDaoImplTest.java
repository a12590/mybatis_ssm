package cn.itcast.ssm.dao.old;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.ssm.po.User;

public class UserDaoImplTest {
	
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		
		applicationContext = new ClassPathXmlApplicationContext(new String[]{
				"spring/applicationContext.xml",
				"spring/applicationContext-dao.xml"
				
		});
	}

	@Test
	public void testFindUserById() throws Exception {
		//从spring容器中获取userdao
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		User user = userDao.findUserById(10);
		System.out.println(user);
	}

}
