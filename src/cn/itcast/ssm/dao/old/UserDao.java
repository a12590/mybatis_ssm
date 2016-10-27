package cn.itcast.ssm.dao.old;

import cn.itcast.ssm.po.User;

/**
 * 
 * <p>Title: UserDao</p>
 * <p>Description:原始 dao </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-18下午4:05:58
 * @version 1.0
 */
public interface UserDao {
	
	//根据用户 id查询用户信息
	public User findUserById(int id) throws Exception;

}
