package com.gowaiterless.api.orderList;

import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//@Entity
public class Order {
	
	@EmbeddedId
	private OrderId orderId;
	private Collection<Item> items;
	private int priceInCents;
	private boolean readyToPay;
	
	public OrderId getOrderId() {
		return orderId;
	}
	public void setOrderId(OrderId orderId) {
		this.orderId = orderId;
	}
	public Collection<Item> getItems() {
		return items;
	}
	public void setItems(Collection<Item> items) {
		this.items = items;
	}
	public int getPriceInCents() {
		return priceInCents;
	}
	public void setPriceInCents(int priceInCents) {
		this.priceInCents = priceInCents;
	}
	public boolean isReadyToPay() {
		return readyToPay;
	}
	public void setReadyToPay(boolean readyToPay) {
		this.readyToPay = readyToPay;
	}
}
