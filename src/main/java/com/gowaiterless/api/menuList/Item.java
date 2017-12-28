package com.gowaiterless.api.menuList;

import javax.persistence.Embeddable;

@Embeddable
public class Item {
	private String itemCode;
	private String itemName;
	private String itemDiscription;
	private int priceInCents;
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
	public int getPriceInCents() {
		return priceInCents;
	}
	public void setPriceInCents(int priceInCents) {
		this.priceInCents = priceInCents;
	}
}
