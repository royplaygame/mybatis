package com.hy.ly.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hy.ly.entity.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao {

	private SqlSessionFactory sqlSessionFactory;

	public  UserInfoDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Override
	public UserInfo findUserById(int userid) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("test.findUserInfoById", userid);
	}

	@Override
	public void addUserInfo(UserInfo userInfo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUserInfo", userInfo);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUserInfo(int userid) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUserInfo",userid);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("test.updateUserInfo", userInfo);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public List<UserInfo> findUserInfoList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserInfo> list = sqlSession.selectList("test.findUserByName", "张");
		return list;
	}

	@Override
	public List<UserInfo> findUserByName(String username) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserInfo> list = sqlSession.selectList("test.findUserByName", "张");
		return list;
	}

}
