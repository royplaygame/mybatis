package com.hy.ly.mapper;

import java.util.List;

import com.hy.ly.entity.UserInfo;

public interface UserInfoMapper {

	public UserInfo findUserInfoById(int userid) throws Exception;
	
	/*public UserInfo findUserById(int userid) throws Exception;

	public void addUserInfo(UserInfo userInfo) throws Exception;

	public void deleteUserInfo(int userid) throws Exception;

	public void updateUserInfo(UserInfo userInfo) throws Exception;

	public List<UserInfo> findUserInfoList() throws Exception;

	public List<UserInfo> findUserByName(String username) throws Exception;*/
}
