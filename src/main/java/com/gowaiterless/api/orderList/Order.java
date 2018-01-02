package com.gowaiterless.api.orderList;

import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//@Entity
public class Order {
	@EmbeddedId
	private OrderId orderId;
	private Collection<Item> items;
	
}
