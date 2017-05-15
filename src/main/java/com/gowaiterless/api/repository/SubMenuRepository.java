package com.gowaiterless.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gowaiterless.SubMenu;

public interface SubMenuRepository extends CrudRepository<SubMenu, Long>{
	public List<SubMenu> findByMenusMenuId(long menuId);
	public List<SubMenu> findByRestaurantId(String restaurantId);
}
