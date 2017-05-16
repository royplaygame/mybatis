package com.hy.ly.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hy.ly.entity.UserInfo;

public class MybatisFirst {

	// 根据userid查询用户信息
	@Test
	public void findUserInfoById() throws IOException {
		SqlSession sqlSession = null;
		try {
			// mybatis配置文件
			String resource = "SqlMapConfig.xml";
			// 获取流
			InputStream is = Resources.getResourceAsStream(resource);
			// 创建会话工厂
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			// 创建sqlSession
			sqlSession = sf.openSession();
			// 通过sqlSession操作数据库
			UserInfo userInfo = sqlSession.selectOne("test.findUserInfoById", 1001);
			System.out.println(userInfo);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}
	
	@Test
	private void test() {
		System.out.println("------------------------");
	}
	public static void main(String[] args) {
		System.out.println("------------------------");
	}
}
