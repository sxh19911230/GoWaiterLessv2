package com.gowaiterless.api.orderList;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.gowaiterless.api.menuList.Menu;

@Entity
public class Item {
	
	@EmbeddedId
	private ItemId itemId;
	
	@ManyToOne
	private Menu menu;
	@ElementCollection (fetch=FetchType.EAGER)
	@CollectionTable
	@Column(length=10,nullable=false)
	private Set<String> choiceList;
	private String specialInstruction;
	private int quantity;
	
	public ItemId getItemId() {
		return itemId;
	}
	public void setItemId(ItemId itemId) {
		this.itemId = itemId;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Set<String> getChoiceList() {
		return choiceList;
	}
	public void setChoiceList(Set<String> choiceList) {
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
