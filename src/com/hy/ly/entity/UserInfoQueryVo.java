package com.hy.ly.entity;


public class UserInfoQueryVo {
	//用户的查询条件
	private UserInfoCustom userInfoCustom;

	public UserInfoCustom getUserInfoCustom() {
		return userInfoCustom;
	}

	public void setUserInfoCustom(UserInfoCustom userInfoCustom) {
		this.userInfoCustom = userInfoCustom;
	}
	
	//其它的查询条件，订单、订单明细、商品的查询条件等等

}
