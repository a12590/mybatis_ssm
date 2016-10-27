package cn.itcast.ssm.dao.old;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.po.User;

/**
 * 
 * <p>Title: UserDaoImpl</p>
 * <p>Description: userdao的实现类</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-18下午4:07:40
 * @version 1.0
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	

	@Override
	public User findUserById(int id) throws Exception {
		//创建SqlSession
		SqlSession sqlSession = this.getSqlSession();
		
		return sqlSession.selectOne("test.findUserById", id);
	}

}
