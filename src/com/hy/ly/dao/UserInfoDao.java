package com.hy.ly.dao;

import java.util.List;

import com.hy.ly.entity.UserInfo;

public interface UserInfoDao {

	public UserInfo findUserById(int userid) throws Exception;

	public void addUserInfo(UserInfo userInfo) throws Exception;

	public void deleteUserInfo(int userid) throws Exception;

	public void updateUserInfo(UserInfo userInfo) throws Exception;

	public List<UserInfo> findUserInfoList() throws Exception;
}
