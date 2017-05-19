package com.hy.ly.mapper;

import java.util.List;

import com.hy.ly.entity.Orders;
import com.hy.ly.entity.OrdersCustom;

public interface OrdersMapperCustom {

	//查询订单关联查询用户
	public List<OrdersCustom> findOrderInfoUser() throws Exception;
	
	//查询订单关联查询用户ResultMap
	public List<Orders> findOrderInfoUserResultMap() throws Exception;

	// 查询订单关联查询用户以及订单明细ResultMap
	public List<Orders> findOrderAndOrderDetailResultMap() throws Exception;
}
