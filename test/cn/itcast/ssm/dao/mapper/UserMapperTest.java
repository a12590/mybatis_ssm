package cn.itcast.ssm.dao.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.ssm.dao.old.UserDao;
import cn.itcast.ssm.po.Student;
import cn.itcast.ssm.po.User;

public class UserMapperTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {

		applicationContext = new ClassPathXmlApplicationContext(new String[] {
				"spring/applicationContext.xml",
				"spring/applicationContext-dao.xml"

		});
	}

	@Test
	public void testFindUserById() throws Exception {
		// 从spring容器中获取userdao
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
	
	
	
	//添加信息
		@Test
		public void testInsert() throws Exception {
			
			UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

			//插入对象
			User user = new User();
			user.setUsername("赵六");
			userMapper.insertUser(user);			
		}
		

}
