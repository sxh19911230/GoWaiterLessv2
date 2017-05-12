package com.gowaiterless.api.item;

import javax.persistence.Embeddable;

@Embeddable
public class Item {
	private String itemCode;
	private String itemName;
	private String itemDiscription;
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDiscription() {
		return itemDiscription;
	}
	public void setItemDiscription(String itemDiscription) {
		this.itemDiscription = itemDiscription;
	}
}
