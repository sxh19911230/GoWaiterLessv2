package com.gowaiterless.api.orderList;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gowaiterless.api.menuList.Restaurant;

@Embeddable
public class OrderId implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JsonIgnoreProperties({"address","restaurantPic","telephone","fax","email","menus","submenus"})
	private Restaurant restaurant;
	private long orderNum;
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orderNum ^ (orderNum >>> 32));
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
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
		OrderId other = (OrderId) obj;
		if (orderNum != other.orderNum)
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}
}
