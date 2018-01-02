package com.gowaiterless.api.menuList;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class MenuId implements Serializable{

	

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	
	private long menuNum;

	
	public MenuId(){}
	
	public MenuId(Restaurant restaurant, long menuIntId) {
		super();
		this.restaurant = restaurant;
		this.menuNum = menuIntId;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public long getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(long menuId) {
		this.menuNum = menuId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (menuNum ^ (menuNum >>> 32));
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
		MenuId other = (MenuId) obj;
		if (menuNum != other.menuNum)
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}
}
