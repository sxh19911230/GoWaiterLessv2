package com.gowaiterless.api.orderList;

import java.util.Collection;

import javax.persistence.Embeddable;

import com.gowaiterless.api.menuList.Menu;

@Embeddable
public class Item {
	private Menu nemu;
	private Collection<String> ChoiceList;
	private String specialInstruction;
	int quantity;
}
