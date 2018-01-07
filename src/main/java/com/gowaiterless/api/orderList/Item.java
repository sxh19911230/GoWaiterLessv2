package com.gowaiterless.api.orderList;

import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.gowaiterless.api.menuList.Choice;
import com.gowaiterless.api.menuList.Menu;

@Entity
public class Item {
	
	@EmbeddedId
	private ItemId itemId;
	
	@ManyToOne
	private Menu nemu;
	@Embedded
	private Collection<Choice> choiceList;
	private String specialInstruction;
	private int quantity;
	
	public ItemId getItemId() {
		return itemId;
	}
	public void setItemId(ItemId itemId) {
		this.itemId = itemId;
	}
	public Menu getNemu() {
		return nemu;
	}
	public void setNemu(Menu nemu) {
		this.nemu = nemu;
	}
	public Collection<Choice> getChoiceList() {
		return choiceList;
	}
	public void setChoiceList(Collection<Choice> choiceList) {
		this.choiceList = choiceList;
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
