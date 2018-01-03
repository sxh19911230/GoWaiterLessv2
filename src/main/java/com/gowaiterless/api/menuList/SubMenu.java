package com.gowaiterless.api.menuList;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubMenu {
	@EmbeddedId
	private SubMenuId subMenuId;
	private String subMenuName;
	private String subMenuDescription;
	private boolean inclusive;
	private int allowed;
	private int free;
	@ElementCollection (fetch=FetchType.EAGER)
	@CollectionTable( uniqueConstraints = {@UniqueConstraint(columnNames={"SubMenu_menuBook_id","choiceCode"})})
	private Collection<Choice> choices;
	
	@JsonIgnore
	@ManyToMany(mappedBy="subMenus")
	private Collection<Menu> menus;
	
	public SubMenu(){subMenuId = new SubMenuId();}
	public SubMenu(SubMenuId id){subMenuId=id;}

	
	public Collection<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Collection<Menu> menus) {
		this.menus = menus;
	}
	
	public SubMenuId getSubMenuId() {
		return subMenuId;
	}
	public void setSubMenuId(SubMenuId subMenuId) {
		this.subMenuId = subMenuId;
	}


	public String getSubMenuName() {
		return subMenuName;
	}
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}
	public boolean isInclusive() {
		return inclusive;
	}
	public void setInclusive(boolean inclusive) {
		this.inclusive = inclusive;
	}
	public int getAllowed() {
		return allowed;
	}
	public void setAllowed(int allowed) {
		this.allowed = allowed;
	}
	public int getFree() {
		return free;
	}
	public void setFree(int free) {
		this.free = free;
	}
	public Collection<Choice> getChoices() {
		return choices;
	}
	public void setChoices(Collection<Choice> choices) {
		this.choices = choices;
	}
	public String getSubMenuDescription() {
		return subMenuDescription;
	}
	public void setSubMenuDescription(String subMenuDescription) {
		this.subMenuDescription = subMenuDescription;
	}

}
