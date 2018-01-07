package com.gowaiterless.api.orderList.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gowaiterless.api.orderList.Item;

@Service
@Transactional
public class ItemService {

	public List<Item> getItems(String restaurantid, long orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Item getItem(String restaurantid, long orderid, int itemid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Item> setItem(String restaurantid, long orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Item> updateItem(String restaurantid, long orderid, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Item> deleteItem(String restaurantid, long orderid) {
		// TODO Auto-generated method stub
		return null;
	}

}
