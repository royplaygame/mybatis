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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		UserInfo userInfo = userInfoMapper.findUserInfoById(1005);
		System.out.println(userInfo);
		sqlSession.close();
	}

	@Test
	public void findUserInfoByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		List<UserInfo> list = userInfoMapper.findUserByName("张");
		for (UserInfo userInfo : list) {
			System.out.println(userInfo);
		}
		sqlSession.close();
	}

	@Test
	public void updateUserInfo() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		UserInfo userInfo = new UserInfo(1010, "吴国太", new Date(), "女", "河南驻马店");
		userInfoMapper.updateUserInfo(userInfo);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void addUserInfo() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		UserInfo userInfo = new UserInfo(1008, "sunshangxiang", new Date(), "男", "河南开封");
		userInfoMapper.insertUserInfo(userInfo);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void deleteUserInfo() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		userInfoMapper.deleteUserInfo(1008);
		sqlSession.commit();
		sqlSession.close();
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void findUserInfoList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		UserInfoQueryVo userInfoQueryVo = new UserInfoQueryVo();
		UserInfoCustom userInfoCustom = new UserInfoCustom();
		userInfoCustom.setSex("女");
		userInfoCustom.setUsername("乔");
		userInfoQueryVo.setUserInfoCustom(userInfoCustom);
		List<Integer> userids = new ArrayList();
		userids.add(1000);
		userids.add(1008);
		userids.add(1109);
		userids.add(1103);
		userInfoQueryVo.setUserids(userids);
		List<UserInfoCustom> list = userInfoMapper.findUserInfoList(userInfoQueryVo);
		for (UserInfoCustom userCustom : list) {
			System.out.println(userCustom.toString());
		}
		sqlSession.close();
	}

	@Test
	public void findUserInfoCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		UserInfoQueryVo userInfoQueryVo = new UserInfoQueryVo();
		UserInfoCustom userInfoCustom = new UserInfoCustom();
		userInfoCustom.setSex("女");
		userInfoCustom.setUsername("乔");
		userInfoQueryVo.setUserInfoCustom(userInfoCustom);
		int count = userInfoMapper.findUserInfoCount(userInfoQueryVo);
		System.out.println(count);
		sqlSession.close();
	}

	@Test
	public void findUserInfoByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		UserInfo userInfo = userInfoMapper.findUserInfoByResultMap(1010);
		System.out.println(userInfo);
		sqlSession.close();
	}

	// 一级缓存测试
	@Test
	public void oneCacheTest() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		// 第一次查询
		UserInfo userInfo1 = userInfoMapper.findUserInfoById(1010);
		System.out.println(userInfo1);

		// 更新用户,执行commit操作，才会去清空缓存
		userInfo1.setUsername("吴国太11111");
		userInfoMapper.updateUserInfo(userInfo1);
		sqlSession.commit();

		// 第二次查询
		UserInfo userInfo2 = userInfoMapper.findUserInfoById(1010);
		System.out.println(userInfo2);
		sqlSession.close();
	}

	// 二级缓存测试
	@Test
	public void towCacheTest() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper1 = sqlSession1.getMapper(UserInfoMapper.class);
		// 第一次查询
		UserInfo userInfo1 = userInfoMapper1.findUserInfoById(1010);
		System.out.println(userInfo1);
		//执行关闭操作，才把sqlSession中的数据写入二级缓存
		sqlSession1.close();
		
		//sqlSession3来执行提交操作
		UserInfoMapper userInfoMapper3 = sqlSession3.getMapper(UserInfoMapper.class);
		UserInfo userInfo3 = userInfoMapper3.findUserInfoById(1010);
		userInfo3.setUsername("吴国太");
		userInfoMapper3.updateUserInfo(userInfo3);
		//提交清空二级缓存
		sqlSession3.commit();
		sqlSession3.close();
		
		UserInfoMapper userInfoMapper2 = sqlSession2.getMapper(UserInfoMapper.class);
		// 第二次查询
		UserInfo userInfo2 = userInfoMapper2.findUserInfoById(1010);
		System.out.println(userInfo2);
		sqlSession2.close();
	}
}
