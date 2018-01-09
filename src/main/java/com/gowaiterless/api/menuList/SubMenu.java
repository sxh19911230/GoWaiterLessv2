package com.gowaiterless.api.menuList;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.UniqueConstraint;

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
	private Set<Choice> choices;

	public SubMenu(){subMenuId = new SubMenuId();}
	public SubMenu(SubMenuId id){subMenuId=id;}

	
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
	public Set<Choice> getChoices() {
		return choices;
	}
	public void setChoices(Set<Choice> choices) {
		this.choices = choices;
	}
	public String getSubMenuDescription() {
		return subMenuDescription;
	}
	public void setSubMenuDescription(String subMenuDescription) {
		this.subMenuDescription = subMenuDescription;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subMenuId == null) ? 0 : subMenuId.hashCode());
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
		SubMenu other = (SubMenu) obj;
		if (subMenuId == null) {
			if (other.subMenuId != null)
				return false;
		} else if (!subMenuId.equals(other.subMenuId))
			return false;
		return true;
	}

}
