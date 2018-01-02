package com.gowaiterless.api.menuList.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.SubMenuId;


public interface SubMenuRepository extends JpaRepository<SubMenu, SubMenuId>{
	public Optional<List<SubMenu>> findByMenusMenuId(SubMenuId menuId);
	public Optional<List<SubMenu>> findBySubMenuIdRestaurantId(String restaurantId);
	public SubMenu findBySubMenuIdRestaurantIdAndChoicesChoiceCode(String restaurantId, String subMenuCode);
	
}
