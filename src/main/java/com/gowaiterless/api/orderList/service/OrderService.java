package com.gowaiterless.api.orderList.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.menuList.Restaurant;
import com.gowaiterless.api.menuList.Sequences;
import com.gowaiterless.api.menuList.repository.SequencesRepository;
import com.gowaiterless.api.menuList.service.RestaurantService;
import com.gowaiterless.api.orderList.Item;
import com.gowaiterless.api.orderList.ItemId;
import com.gowaiterless.api.orderList.Order;
import com.gowaiterless.api.orderList.OrderId;
import com.gowaiterless.api.orderList.repository.ItemRepository;
import com.gowaiterless.api.orderList.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	RestaurantService restaurantService;
	@Autowired
	SequencesRepository sequenceRepository;
	@Autowired
	ItemRepository itemRepository;

	public List<Order> getOrders(String restaurantid) {
		return orderRepository.findByOrderIdRestaurantId(restaurantid).orElse(new ArrayList<Order>());
	}

	public Order getOrder(String restaurantid, long orderid) {
		return orderRepository.findOne(new OrderId(restaurantService.getRestaurant(restaurantid),orderid));
	}

	public Order updateOrder(String restaurantid, long orderid, Order order) {
		order.setOrderId(new OrderId(restaurantService.getRestaurant(restaurantid),orderid));
		return orderRepository.saveAndFlush(order);
	}

	public void deleteOrder(String restaurantid, long orderid) {
		orderRepository.delete(new OrderId(restaurantService.getRestaurant(restaurantid),orderid));
	}

	public Order placeOrder(String restaurantid, Order order) {
		//set id
		Restaurant r = restaurantService.getRestaurant(restaurantid);
		Sequences a = sequenceRepository.getOne(restaurantid+"_order");
		order.setOrderId(new OrderId(r,a.getNext()));
		a.setNext(a.getNext()+1);
		sequenceRepository.save(a);
		//save items
		int i = 0;
		for (Item item : order.getItems()) {
			item.setItemId(new ItemId(order, ++i));
			itemRepository.save(item);
		}
		// save order
		return orderRepository.saveAndFlush(order);
	}

}
