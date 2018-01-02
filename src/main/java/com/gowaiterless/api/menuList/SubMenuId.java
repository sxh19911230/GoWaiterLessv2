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
	
	private long subMenuNum;

	
	public SubMenuId(){}
	
	public SubMenuId(Restaurant restaurant, long subMenuId) {
		super();
		this.restaurant = restaurant;
		this.subMenuNum = subMenuId;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public long getSubMenuNum() {
		return subMenuNum;
	}

	public void setSubMenuNum(long menuId) {
		this.subMenuNum = menuId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		result = prime * result + (int) (subMenuNum ^ (subMenuNum >>> 32));
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
		SubMenuId other = (SubMenuId) obj;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		if (subMenuNum != other.subMenuNum)
			return false;
		return true;
	}

}
