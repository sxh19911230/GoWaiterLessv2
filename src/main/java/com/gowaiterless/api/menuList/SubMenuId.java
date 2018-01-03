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
	private MenuBook menuBook;
	
	private long subMenuNum;

	
	public SubMenuId(){}
	
	public SubMenuId(MenuBook menuBook, long subMenuId) {
		super();
		this.menuBook = menuBook;
		this.subMenuNum = subMenuId;
	}
	
	public MenuBook getMenuBook() {
		return menuBook;
	}

	public void setMenuBook(MenuBook menuBook) {
		this.menuBook = menuBook;
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
		result = prime * result + ((menuBook == null) ? 0 : menuBook.hashCode());
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
		if (menuBook == null) {
			if (other.menuBook != null)
				return false;
		} else if (!menuBook.equals(other.menuBook))
			return false;
		if (subMenuNum != other.subMenuNum)
			return false;
		return true;
	}

	
}
