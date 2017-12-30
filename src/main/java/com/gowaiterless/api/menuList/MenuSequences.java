package com.gowaiterless.api.menuList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuSequences {
	
	

	@Id
	private String menuId;
	private int count;
	
	public MenuSequences(String id, int i) {
		menuId= id;
		count = i;
	}
	
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
