package com.hy.ly.entity;

import java.util.Date;
import java.util.List;

public class UserInfo {
	private int userid;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	private List<Orders> orderList;


	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex
				+ ", address=" + address + "]";
	}

	public UserInfo(int userid,String username, Date birthday, String sex, String address) {
		super();
		this.userid=userid;
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}

	public UserInfo() {
		super();
	}
	

}
