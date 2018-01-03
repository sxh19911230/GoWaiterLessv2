package com.gowaiterless.api.menuList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuSequences {
	
	

	@Id
	private String menuId;
	private int next;
	
	public MenuSequences(){}
	
	public MenuSequences(String id, int i) {
		menuId= id;
		next = i;
	}
	
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
	
	
}
