package com.gowaiterless.api.menuList;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class SubMenuId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	
	private long subMenuId;

	
	public SubMenuId(){}
	
	public SubMenuId(Restaurant restaurant, long subMenuId) {
		super();
		this.restaurant = restaurant;
		this.subMenuId = subMenuId;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public long getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(long menuId) {
		this.subMenuId = menuId;
	}



}
