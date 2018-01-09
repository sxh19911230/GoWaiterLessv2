package com.gowaiterless.api.orderList.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowaiterless.api.orderList.Item;
import com.gowaiterless.api.orderList.ItemId;
import com.gowaiterless.api.orderList.Order;

public interface ItemRepository extends JpaRepository<Item, ItemId> {
	Optional<List<Item>> findByItemIdOrder(Order order);
	//Item findByItemIdOrderItemsItemId(ItemId itemId);
}
