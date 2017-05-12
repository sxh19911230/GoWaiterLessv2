package com.gowaiterless.api.menu;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.gowaiterless.api.submenu.SubMenu;

@Entity
public class Menu {
	@Id @GeneratedValue
	int menuId;
	String dishName;
	String dishDescription;
	String picture;
	int basePriceInCent;
	@ManyToOne
	String restaurantId;
	@ManyToMany
	Collection<SubMenu> subMenus;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDishDescription() {
		return dishDescription;
	}
	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getBasePriceInCent() {
		return basePriceInCent;
	}
	public void setBasePriceInCent(int basePriceInCent) {
		this.basePriceInCent = basePriceInCent;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Collection<SubMenu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(Collection<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	
}
