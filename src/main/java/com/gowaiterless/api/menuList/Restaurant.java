package com.gowaiterless.api.menuList;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gowaiterless.api.orderList.Order;

@Entity
public class Restaurant {
	
	@Id
	@Column(length = 50)
	private String id;
	private String name;
	private Address address;
	private String restaurantPic;
	private String telephone;
	private String fax;
	private String email;
	@ManyToOne
	private MenuBook menuBook;
	@JsonIgnore
	@OneToMany(mappedBy="orderId.restaurant")
	private Collection<Order> orders;
	
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
	
	public MenuBook getMenuBook() {
		return menuBook;
	}

	public void setMenuBook(MenuBook menuBook) {
		this.menuBook = menuBook;
	}
	
	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
