package com.gowaiterless.api.menuList;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MenuId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String restaurantStringId;
	private long menuLongId;
	
	public MenuId(){}
	
	public MenuId(String restaurant, long menuIntId) {
		super();
		this.restaurantStringId = restaurant;
		this.menuLongId = menuIntId;
	}
	
	public String getRestaurant() {
		return restaurantStringId;
	}
	public void setRestaurant(String restaurant) {
		this.restaurantStringId = restaurant;
	}
	public long getMenuLongId() {
		return menuLongId;
	}
	public void setMenuLongId(long menuIntId) {
		this.menuLongId = menuIntId;
	}
}
