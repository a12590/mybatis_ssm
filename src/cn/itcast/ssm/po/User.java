package cn.itcast.ssm.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p>Title: User</p>
 * <p>Description: user表对应的po类</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-17上午9:59:48
 * @version 1.0
 */
public class User implements Serializable {

	private int id;
	private String username;// 用户姓名
	private String sex;// 性别
	private Date birthday;// 出生日期
	private String address;// 地址
	private String detail;// 详细信息
	private Float score;// 成绩
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex
				+ ", birthday=" + birthday + ", address=" + address
				+ ", detail=" + detail + ", score=" + score + "]";
	}
	
	
	

}
