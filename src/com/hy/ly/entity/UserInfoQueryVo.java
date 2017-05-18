package com.hy.ly.entity;

import java.util.List;

public class UserInfoQueryVo {
	private List<Integer> userids;
	//用户的查询条件
	private UserInfoCustom userInfoCustom;

	public UserInfoCustom getUserInfoCustom() {
		return userInfoCustom;
	}

	public void setUserInfoCustom(UserInfoCustom userInfoCustom) {
		this.userInfoCustom = userInfoCustom;
	}

	public List<Integer> getUserids() {
		return userids;
	}

	public void setUserids(List<Integer> userids) {
		this.userids = userids;
	}
	
	//其它的查询条件，订单、订单明细、商品的查询条件等等

}
