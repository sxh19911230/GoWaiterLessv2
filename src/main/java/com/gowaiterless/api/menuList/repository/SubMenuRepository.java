package com.gowaiterless.api.menuList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.SubMenuId;


public interface SubMenuRepository extends JpaRepository<SubMenu, SubMenuId>{
	public List<SubMenu> findByMenusMenuId(SubMenuId menuId);
	public List<SubMenu> findBySubMenuIdRestaurantId(String restaurantId);
}
