package com.hy.ly.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hy.ly.entity.UserInfo;

public class UserInfoDaoImplTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception{
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 获取流
		InputStream is = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void test() throws Exception {
		UserInfoDao userInfoDao = new UserInfoDaoImpl(sqlSessionFactory);
		UserInfo userInfo=userInfoDao.findUserById(1105);
		System.out.println(userInfo);
	}

}
