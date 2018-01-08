package com.gowaiterless.api.menuList;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class MenuId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	private MenuBook menuBook;
	
	private long menuNum;

	
	public MenuId(){}
	
	public MenuId(MenuBook menuBook, long menuIntId) {
		super();
		this.menuBook = menuBook;
		this.menuNum = menuIntId;
	}
	

	public long getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(long menuId) {
		this.menuNum = menuId;
	}
	@JsonIgnore
	public MenuBook getMenuBook() {
		return menuBook;
	}

	@JsonProperty
	public void setMenuBook(MenuBook menuBook) {
		this.menuBook = menuBook;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuBook == null) ? 0 : menuBook.hashCode());
		result = prime * result + (int) (menuNum ^ (menuNum >>> 32));
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
		MenuId other = (MenuId) obj;
		if (menuBook == null) {
			if (other.menuBook != null)
				return false;
		} else if (!menuBook.equals(other.menuBook))
			return false;
		if (menuNum != other.menuNum)
			return false;
		return true;
	}
	

}