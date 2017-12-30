package com.gowaiterless.api.menuList;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubMenu implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long subMenuId;
	private String subMenuName;
	private String subMenuDescription;
	private boolean inclusive;
	private int allowed;
	private int free;
	@ElementCollection (fetch=FetchType.EAGER)
	private Collection<Choice> choices;
	
	@JsonIgnore
	@ManyToMany(mappedBy="subMenus")
	private Collection<Menu> menus;

	
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	
	public SubMenu(){}
	public SubMenu(long id){subMenuId=id;}

	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
		//this.restaurantId=123;
	}
	public Collection<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Collection<Menu> menus) {
		this.menus = menus;
	}
	
	public long getSubMenuId() {
		return subMenuId;
	}
	public void setSubMenuId(long subMenuId) {
		this.subMenuId = subMenuId;
	}


	public String getSubMenuName() {
		return subMenuName;
	}
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}
	public boolean isInclusive() {
		return inclusive;
	}
	public void setInclusive(boolean inclusive) {
		this.inclusive = inclusive;
	}
	public int getAllowed() {
		return allowed;
	}
	public void setAllowed(int allowed) {
		this.allowed = allowed;
	}
	public int getFree() {
		return free;
	}
	public void setFree(int free) {
		this.free = free;
	}
	public Collection<Choice> getItems() {
		return choices;
	}
	public void setItems(Collection<Choice> choices) {
		this.choices = choices;
	}
	public String getSubMenuDescription() {
		return subMenuDescription;
	}
	public void setSubMenuDescription(String subMenuDescription) {
		this.subMenuDescription = subMenuDescription;
	}

}
