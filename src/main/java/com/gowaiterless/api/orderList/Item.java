package com.gowaiterless.api.orderList;

import java.util.Collection;

import javax.persistence.Embeddable;

import com.gowaiterless.api.menuList.Choice;
import com.gowaiterless.api.menuList.Menu;

@Embeddable
public class Item {
	
	private Menu nemu;
	private Collection<Choice> ChoiceList;
	private String specialInstruction;
	private int quantity;
	
	public Menu getNemu() {
		return nemu;
	}
	public void setNemu(Menu nemu) {
		this.nemu = nemu;
	}
	public Collection<Choice> getChoiceList() {
		return ChoiceList;
	}
	public void setChoiceList(Collection<Choice> choiceList) {
		ChoiceList = choiceList;
	}
	public String getSpecialInstruction() {
		return specialInstruction;
	}
	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
