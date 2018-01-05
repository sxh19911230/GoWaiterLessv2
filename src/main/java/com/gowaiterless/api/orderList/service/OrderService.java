package com.gowaiterless.api.orderList.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gowaiterless.api.orderList.Order;

@Service
@Transactional
public class OrderService {

	public List<Order> getOrders(String restaurantid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order getOrder(String restaurantid, long orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order updateOrder(String restaurantid, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOrder(String restaurantid, long orderid) {
		// TODO Auto-generated method stub
		
	}

	public Order placeOrder(String restaurantid, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
