package com.gowaiterless;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Menu {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long menuId;
	private String menuCode;
	private String dishName;
	private String dishDescription;
	private String picture;
	private int basePriceInCent;
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	@JsonIgnore
	@ManyToMany
	private Collection<SubMenu> subMenus;
	private boolean active;
	
	public Menu(){}
	public Menu(long id) {menuId=id;}
	
	public Collection<SubMenu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(Collection<SubMenu> submenus) {
		this.subMenus = submenus;
	}
	public long getMenuId() {
		return menuId;
	}
	public void setMenuId(long menuId) {
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

	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	
}
