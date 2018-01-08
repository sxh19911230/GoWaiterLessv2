package com.gowaiterless.api.orderList;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="orders")
public class Order {
	
	@EmbeddedId
	private OrderId orderId;
	
	
	@OneToMany(mappedBy="itemId.order", fetch=FetchType.LAZY)
	private Collection<Item> items = new ArrayList<Item>();
	private int priceInCents;
	private boolean paid;
	private Timestamp placedTime;
	
	public Order(OrderId orderid) {
		orderId = orderid;
	}
	public Order(){}
	
	public OrderId getOrderId() {
		return orderId;
	}
	public void setOrderId(OrderId orderId) {
		this.orderId = orderId;
	}
	@JsonIgnore
	public Collection<Item> getItems() {
		return items;
	}
	@JsonProperty
	public void setItems(Collection<Item> items) {
		this.items = items;
	}
	public int getPriceInCents() {
		return priceInCents;
	}
	public void setPriceInCents(int priceInCents) {
		this.priceInCents = priceInCents;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	
	public Timestamp getPlacedTime() {
		return placedTime;
	}
	public void setPlacedTime(Timestamp placedTime) {
		this.placedTime = placedTime;
	}
}
