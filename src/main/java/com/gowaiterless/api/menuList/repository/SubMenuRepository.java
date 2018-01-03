package com.gowaiterless.api.menuList.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.SubMenuId;


public interface SubMenuRepository extends JpaRepository<SubMenu, SubMenuId>{
	public Optional<List<SubMenu>> findByMenusMenuId(SubMenuId submenuId);
	public Optional<List<SubMenu>> findBySubMenuIdMenuBookId(long submenubookid);
	public SubMenu findBySubMenuIdMenuBookIdAndChoicesChoiceCode(long submenubookid, String subMenuCode);
	
}
