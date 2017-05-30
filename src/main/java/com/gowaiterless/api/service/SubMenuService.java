package com.gowaiterless.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.Restaurant;
import com.gowaiterless.api.SubMenu;
import com.gowaiterless.api.repository.RestaurantRepository;
import com.gowaiterless.api.repository.SubMenuRepository;
import com.gowaiterless.exception.ResourceNotFoundException;


@Service
@Transactional
public class SubMenuService {
	@Autowired
	SubMenuRepository subMenuRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public List<SubMenu> getSubMenus(String restaurantId, long menuId) {
		getRestaurant(restaurantId);
		return subMenuRepository.findByMenusMenuId(menuId);
	}
	public SubMenu getSubMenu(String restaurantId, long subMenuId) {
		getRestaurant(restaurantId);
		return getSubMenu(subMenuId);
	}
	public SubMenu addSubMenu(String restaurantId, SubMenu s) {
		s.setSubMenuId(0);
		s.setRestaurant(getRestaurant(restaurantId));
		subMenuRepository.saveAndFlush(s);
		return s;
	}
	public SubMenu updateSubMenu(String restaurantId, long subMenuId, SubMenu s) {
		getSubMenu(subMenuId);
		s.setSubMenuId(subMenuId);
		s.setRestaurant(getRestaurant(restaurantId));
		subMenuRepository.saveAndFlush(s);
		return s;
	}
	public void deleteSubMenu(String restaurantId, long subMenuId) {
		getRestaurant(restaurantId);
		subMenuRepository.delete(getSubMenu(subMenuId));
	}
	public List<SubMenu> getSubMenus(String restaurantId) {
		getRestaurant(restaurantId);
		return subMenuRepository.findByRestaurantId(restaurantId);
	}
	
	private Restaurant getRestaurant(String restaurantId) {
		Restaurant r = restaurantRepository.findOne(restaurantId);
		if(r==null) throw new ResourceNotFoundException();
		return r;
	}
	
	private SubMenu getSubMenu(long subMenuId) {
		SubMenu s = subMenuRepository.findOne(subMenuId);
		if(s==null) throw new ResourceNotFoundException();
		return s;
	}

}
