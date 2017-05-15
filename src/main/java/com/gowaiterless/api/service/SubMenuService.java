package com.gowaiterless.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.Restaurant;
import com.gowaiterless.SubMenu;
import com.gowaiterless.api.repository.SubMenuRepository;


@Service
public class SubMenuService {
	@Autowired
	SubMenuRepository subMenuRepository;
	
	public List<SubMenu> getSubMenus(long menuId) {
		return subMenuRepository.findByMenusMenuId(menuId);
	}
	public SubMenu getSubMenu(long id) {
		return subMenuRepository.findOne(id);
	}
	public void addSubMenu(String restaurantId, SubMenu s) {
		s.setRestaurant(new Restaurant(restaurantId));
		subMenuRepository.save(s);
	}
	public void updateSubMenu(String restaurantId, SubMenu s) {
		s.setRestaurant(new Restaurant(restaurantId));
		subMenuRepository.save(s);
	}
	public void deleteSubMenu(long id) {
		subMenuRepository.delete(id);
	}
	public List<SubMenu> getSubMenus(String restaurantId) {
		return subMenuRepository.findByRestaurantId(restaurantId);
	}

}
