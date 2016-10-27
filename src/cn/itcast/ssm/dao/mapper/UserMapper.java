package cn.itcast.ssm.dao.mapper;

import java.util.List;

import cn.itcast.ssm.po.User;

/**
 * 
 * <p>
 * Title: UserMapper
 * </p>
 * <p>
 * Description:mapper接口
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2014-12-17下午3:12:26
 * @version 1.0
 */
public interface UserMapper {

	// 根据用户id查询用户信息
	public User findUserById(int id) throws Exception;

	// 更新用户
	public void updateUser(User user) throws Exception;
	
	// 插入用户
	public int insertUser(User user) throws Exception;

}
