package com.gowaiterless.api.orderList.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.menuList.Restaurant;
import com.gowaiterless.api.menuList.service.RestaurantService;
import com.gowaiterless.api.orderList.Item;
import com.gowaiterless.api.orderList.ItemId;
import com.gowaiterless.api.orderList.Order;
import com.gowaiterless.api.orderList.OrderId;
import com.gowaiterless.api.orderList.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	RestaurantService restaurantService;
	@Autowired
	OrderService orderService;

	public List<Item> getItems(String restaurantid, long orderid) {
		return itemRepository.findByItemIdOrder(orderService.getOrder(restaurantid, orderid)).orElse(new ArrayList<Item>());
	}

	public Item getItem(String restaurantid, long orderid, int itemid) {
		return itemRepository.getOne(new ItemId(orderService.getOrder(restaurantid, orderid), itemid));
	}

	public Item setItem(String restaurantid, long orderid, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Item updateItem(String restaurantid, long orderid, int itemid, Item item) {
		return itemRepository.saveAndFlush(item);
	}

	public List<Item> deleteItem(String restaurantid, long orderid,int itemid) {
		itemRepository.delete(new ItemId(orderService.getOrder(restaurantid, orderid),itemid));
		return null;
	}

	

}
