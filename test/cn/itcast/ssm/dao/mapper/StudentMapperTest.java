package cn.itcast.ssm.dao.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.ssm.po.Student;
import cn.itcast.ssm.po.StudentExample;

public class StudentMapperTest {

	private ApplicationContext applicationContext;
	
	private StudentMapper studentMapper;

	@Before
	public void setUp() throws Exception {

		applicationContext = new ClassPathXmlApplicationContext(new String[] {
				"spring/applicationContext.xml",
				"spring/applicationContext-dao.xml"

		});
		
		studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
	}

	//根据主键删除
	@Test
	public void testDeleteByPrimaryKey() {
		studentMapper.deleteByPrimaryKey(4);
		
		//自定义条件删除，符合条件的全部删除
		//studentMapper.deleteByExample(example)
		
	}
	//添加信息
	@Test
	public void testInsert() {
		//插入对象
		Student student = new Student();
		student.setName("赵六");
		studentMapper.insert(student);
	}

	//根据查询条件查询信息
	@Test
	public void testSelectByExample() {
		
		//自定义条件
		StudentExample studentExample = new StudentExample();
		StudentExample.Criteria criteria = studentExample.createCriteria();
		//拼接查询条件
		criteria.andSexEqualTo("2");//sex等于2
		criteria.andNameEqualTo("王五");//姓名 等于王五
				
		
		//根据查询条件查询返回集合对象
		List<Student> list = studentMapper.selectByExample(studentExample);
		
		System.out.println(list.size());
		
	}

	//根据主键查询信息
	@Test
	public void testSelectByPrimaryKey() {
		
		Student student = studentMapper.selectByPrimaryKey(1);
		
		System.out.println(student);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		//传入更新对象，必须要id，对象中不空的属性才更新
		
		Student student = new Student();
		student.setId(10);
		student.setName("王五");
		
		studentMapper.updateByPrimaryKeySelective(student);
	}
	
	//根据主键更新信息
	
	@Test
	public void testUpdateByPrimaryKey() {
		
		//传入更新对象，必须要id，不管对象中属性是否为空全部更新
		
		//必须先从数据库查询出原始记录
		Student student = studentMapper.selectByPrimaryKey(3);
		//设置更新内容
		student.setName("王小五");
		studentMapper.updateByPrimaryKey(student);
	}

}
