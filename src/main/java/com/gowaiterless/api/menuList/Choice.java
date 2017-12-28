package com.gowaiterless.api.menuList;

import javax.persistence.Embeddable;

@Embeddable
public class Choice {
	private String choiceCode;
	private String choiceName;
	private String choiceDiscription;
	private int priceInCents;
	public String getChoiceCode() {
		return choiceCode;
	}
	public void setChoiceCode(String itemCode) {
		this.choiceCode = itemCode;
	}
	public String getChoiceName() {
		return choiceName;
	}
	public void setChoiceName(String itemName) {
		this.choiceName = itemName;
	}
	public String getChoiceDiscription() {
		return choiceDiscription;
	}
	public void setChoiceDiscription(String itemDiscription) {
		this.choiceDiscription = itemDiscription;
	}
	public int getPriceInCents() {
		return priceInCents;
	}
	public void setPriceInCents(int priceInCents) {
		this.priceInCents = priceInCents;
	}
}
