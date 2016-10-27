package cn.itcast.ssm.service;

import cn.itcast.ssm.po.User;

/**
 * 
 * <p>Title: UserService</p>
 * <p>Description: 用户管理</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-18下午4:46:51
 * @version 1.0
 */
public interface UserService {
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//测试事务控制 
	public void saveUser()throws Exception;
	
	//
    public void insertUser(User user)throws Exception;

}
