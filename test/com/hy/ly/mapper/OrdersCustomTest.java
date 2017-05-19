package com.hy.ly.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hy.ly.entity.OrderDetail;
import com.hy.ly.entity.Orders;
import com.hy.ly.entity.OrdersCustom;
import com.hy.ly.entity.UserInfo;

public class OrdersCustomTest {
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
	public void findOrdersCustom() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrdersCustom> list = ordersMapperCustom.findOrderInfoUser();
		for(OrdersCustom oc:list){
			System.out.println(oc.toString());
		}
		sqlSession.close();
	}
	@Test
	public void findOrdersResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrderInfoUserResultMap();
		for(Orders order:list){
			System.out.println(order+order.getUserInfo().toString());
		}
		sqlSession.close();
	}
	@Test
	public void findOrderAndOrderDetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrderAndOrderDetailResultMap();
		for(Orders order:list){
			System.out.println(order+order.getUserInfo().toString());
			for(OrderDetail od:order.getOrderDetails()){
				System.out.println(od.toString());
			}
			System.out.println("------------------------------------------------------------");
		}
		
		sqlSession.close();
	}
	@Test
	public void findUserInfoAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<UserInfo> list = ordersMapperCustom.findUserInfoAndItemsResultMap();
		for(UserInfo u:list){
			System.out.println(u);
			for(Orders o:u.getOrderList()){
				System.out.println(o);
				for(OrderDetail od:o.getOrderDetails()){
					System.out.println(od);
					System.out.println(od.getItem());
				}
			}
			System.out.println("-----------------------------------------------------------------------");
		}
		
		sqlSession.close();
	}
}
