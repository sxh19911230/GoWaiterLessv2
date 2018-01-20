package com.gowaiterless.api.menuList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Proxy(lazy = false)
public class MenuBook {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String menuBookName;
	
	
	@JsonIgnore
	@OneToMany (mappedBy="menuId.menuBook", fetch=FetchType.LAZY)
	private Collection<Menu> menus= new ArrayList<Menu>();
	@JsonIgnore
	@OneToMany (mappedBy="subMenuId.menuBook", fetch=FetchType.LAZY)
	private Collection<SubMenu> subMenus= new ArrayList<SubMenu>();
	
	@JsonIgnore
	@OneToMany(mappedBy="menuBook")
	private Set<Restaurant> restaurants;

	/* TODO
	the view, design, structure of the menu.
	how it looks
	XML design?
	 */
	public MenuBook() {}
	public MenuBook(long menukoobid) {
		id=menukoobid;
	}
	public long getId() {
		return id;
	}
	public void setId(long menuBookId) {
		this.id = menuBookId;
	}
	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
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
	public String getMenuBookName() {
		return menuBookName;
	}
	public void setMenuBookName(String menuBookName) {
		this.menuBookName = menuBookName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		MenuBook other = (MenuBook) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@PreRemove
	public void nullifRemoved() {
		restaurants.forEach(r->r.setMenuBook(null));
	}
	

}
