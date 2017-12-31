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
	
	private long menuId;

	
	public MenuId(){}
	
	public MenuId(Restaurant restaurant, long menuIntId) {
		super();
		this.restaurant = restaurant;
		this.menuId = menuIntId;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}



}
