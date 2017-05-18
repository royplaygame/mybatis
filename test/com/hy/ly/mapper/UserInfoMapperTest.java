package com.hy.ly.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hy.ly.entity.UserInfo;
import com.hy.ly.entity.UserInfoCustom;
import com.hy.ly.entity.UserInfoQueryVo;

public class UserInfoMapperTest {
	
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
	public void findUserInfoById() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
		UserInfo userInfo=userInfoMapper.findUserInfoById(1005);
		System.out.println(userInfo);
		sqlSession.close();
	}
	
	@Test
	public void findUserInfoByName() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
		List<UserInfo> list=userInfoMapper.findUserByName("张");
		for(UserInfo userInfo:list){
			System.out.println(userInfo);
		}
		sqlSession.close();
	}
	@Test
	public void updateUserInfo() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
		UserInfo userInfo = new UserInfo(1010, "吴国太", new Date(), "女", "河南驻马店");
		userInfoMapper.updateUserInfo(userInfo);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void addUserInfo() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
		UserInfo userInfo = new UserInfo(1008, "sunshangxiang", new Date(), "男", "河南开封");
		userInfoMapper.insertUserInfo(userInfo);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void deleteUserInfo() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
		userInfoMapper.deleteUserInfo(1008);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void findUserInfoList() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
		UserInfoQueryVo userInfoQueryVo=new UserInfoQueryVo();
		UserInfoCustom userInfoCustom=new UserInfoCustom();
		userInfoCustom.setSex("女");
		userInfoCustom.setUsername("乔");
		userInfoQueryVo.setUserInfoCustom(userInfoCustom);
		List<Integer> userids=new ArrayList();
		userids.add(1000);
		userids.add(1008);
		userids.add(1109);
		userids.add(1103);
		userInfoQueryVo.setUserids(userids);
		List<UserInfoCustom> list=userInfoMapper.findUserInfoList(userInfoQueryVo);
		for(UserInfoCustom userCustom:list){
			System.out.println(userCustom.toString());
		}
		sqlSession.close();
	}
	@Test
	public void findUserInfoCount() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
		UserInfoQueryVo userInfoQueryVo=new UserInfoQueryVo();
		UserInfoCustom userInfoCustom=new UserInfoCustom();
		userInfoCustom.setSex("女");
		userInfoCustom.setUsername("乔");
		userInfoQueryVo.setUserInfoCustom(userInfoCustom);
		int count=userInfoMapper.findUserInfoCount(userInfoQueryVo);
		System.out.println(count);
		sqlSession.close();
	}
	
	@Test
	public void findUserInfoByIdResultMap() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper=sqlSession.getMapper(UserInfoMapper.class);
		UserInfo userInfo=userInfoMapper.findUserInfoByResultMap(1010);
		System.out.println(userInfo);
		sqlSession.close();
	}
}
