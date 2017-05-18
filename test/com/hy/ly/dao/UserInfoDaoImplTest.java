package com.hy.ly.dao;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hy.ly.entity.UserInfo;

public class UserInfoDaoImplTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 获取流
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void findTest() throws Exception {
		UserInfoDao userInfoDao = new UserInfoDaoImpl(sqlSessionFactory);
		UserInfo userInfo = userInfoDao.findUserById(1105);
		System.out.println(userInfo);
	}

	@Test
	public void addTest() throws Exception {
		UserInfoDao userInfoDao = new UserInfoDaoImpl(sqlSessionFactory);
		UserInfo userInfo = new UserInfo(1000, "sunshangxiang", new Date(), "女", "河南开封");
		userInfoDao.addUserInfo(userInfo);
		System.out.println(userInfo.getUserid());
	}

	@Test
	public void updateTest() throws Exception {
		UserInfoDao userInfoDao = new UserInfoDaoImpl(sqlSessionFactory);
		UserInfo userInfo = new UserInfo(1002, "孙尚香", new Date(), "女", "河南开封");
		userInfoDao.updateUserInfo(userInfo);
	}

	@Test
	public void deleTeest() throws Exception {
		UserInfoDao userInfoDao = new UserInfoDaoImpl(sqlSessionFactory);
		userInfoDao.deleteUserInfo(1004);
	}

}
