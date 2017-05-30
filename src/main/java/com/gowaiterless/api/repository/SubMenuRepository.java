package com.gowaiterless.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowaiterless.api.SubMenu;

public interface SubMenuRepository extends JpaRepository<SubMenu, Long>{
	public List<SubMenu> findByMenusMenuId(long menuId);
	public List<SubMenu> findByRestaurantId(String restaurantId);
}
