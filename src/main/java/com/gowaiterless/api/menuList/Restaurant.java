package com.gowaiterless.api.menuList;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Restaurant {
	@Id
	private String id;
	private String name;
	private Address address;
	private String restaurantPic;
	private String telephone;
	private String fax;
	private String email;
	
	@JsonIgnore
	@OneToMany (mappedBy="menuId.restaurant")
	private Collection<Menu> menus;
	
	@JsonIgnore
	@OneToMany (mappedBy="subMenuId.restaurant")
	private Collection<SubMenu> subMenus;
	
	public Restaurant() {}
	
	public Restaurant(String id) {
		this.id=id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getRestaurantPic() {
		return restaurantPic;
	}
	public void setRestaurantPic(String restaurantPic) {
		this.restaurantPic = restaurantPic;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Collection<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Collection<Menu> menus) {
		this.menus = menus;
	}
	
	public Collection<SubMenu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(Collection<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}
}
