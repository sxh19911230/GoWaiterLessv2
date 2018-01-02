package com.gowaiterless.api.menuList;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"restaurant_id" , "menuCode"})})
public class Menu {
	@EmbeddedId
	private MenuId menuId;

	@JsonIgnore
	@ManyToMany
	private Collection<SubMenu> subMenus;
	
	@Column(length=10)
	private String menuCode;
	@Column(nullable=false)
	private String dishName;
	private String dishDescription;
	private String picture;
	private int basePriceInCent;
	private boolean active = true;
	
	public Menu(){menuId = new MenuId();}
	public Menu(MenuId id) {menuId=id;}
	
	public Collection<SubMenu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(Collection<SubMenu> submenus) {
		this.subMenus = submenus;
	}
	public MenuId getMenuId() {
		return menuId;
	}
	public void setMenuId(MenuId menuId) {
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
