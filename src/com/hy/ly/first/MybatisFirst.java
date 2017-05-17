package com.hy.ly.first;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hy.ly.entity.UserInfo;

public class MybatisFirst {

	// 根据userid查询用户信息
	@Test
	public void findUserInfoById() {
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
	public void findUserInfoByName() {
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
			List<UserInfo> list = sqlSession.selectList("test.findUserByName", "张");
			for(UserInfo u:list){
				System.out.println(u);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void addUserInfo() {
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
			UserInfo userInfo=new UserInfo(1000,"sunshangxiang",new Date(),"女","河南开封");
			// 通过sqlSession操作数据库
			sqlSession.insert("test.insertUserInfo", userInfo);
			sqlSession.commit();
			System.out.println(userInfo.getUserid());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void deleteUserInfo() {
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
			sqlSession.delete("test.deleteUserInfo",1001);
			sqlSession.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void updateUserInfo() {
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
			UserInfo userInfo=new UserInfo(1109,"孙尚香",new Date(),"女","河南信阳");
			// 通过sqlSession操作数据库
			sqlSession.update("test.updateUserInfo", userInfo);
			sqlSession.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
