package com.gowaiterless.api.menuList;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Choice {
	
	@Column(nullable = false, length=10)
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((choiceCode == null) ? 0 : choiceCode.hashCode());
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
		Choice other = (Choice) obj;
		if (choiceCode == null) {
			if (other.choiceCode != null)
				return false;
		} else if (!choiceCode.equals(other.choiceCode))
			return false;
		return true;
	}
}
