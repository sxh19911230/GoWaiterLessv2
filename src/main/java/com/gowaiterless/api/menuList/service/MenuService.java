package com.gowaiterless.api.menuList.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.menuList.Menu;
import com.gowaiterless.api.menuList.Restaurant;
import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.repository.MenuRepository;
import com.gowaiterless.api.menuList.repository.MenuSequencesRepository;
import com.gowaiterless.api.menuList.repository.RestaurantRepository;
import com.gowaiterless.api.menuList.repository.SubMenuRepository;
import com.gowaiterless.exception.ResourceNotFoundException;

@Service
@Transactional
public class MenuService {
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	SubMenuRepository subMenuRepository;
	@Autowired
	MenuSequencesRepository menuSequencesRepository;
	
	public List<Menu> getMenus(String resId) {
		return menuRepository.findByRestaurantId(resId).orElseThrow(()->new ResourceNotFoundException());
	}
	
	public Menu getMenu(String restaurantId, long id) {
		getRestaurant(restaurantId);
		return menuRepository.findOne(id);
	}
	
	public Menu addMenu(String restaurantId, Menu m) {
		getRestaurant(restaurantId);
		m.setRestaurant(new Restaurant(restaurantId));
		menuRepository.saveAndFlush(m);
		return m;
	}
	
	public Menu updateMenu(String restaurantId, long menuId, Menu m) {
		getRestaurant(restaurantId);
		getMenu(menuId);
		m.setRestaurant(new Restaurant(restaurantId));
		m.setMenuId(menuId);
		menuRepository.saveAndFlush(m);
		return m;
	}
	
	public void deleteMenu(String restaurantId, long menuId) {
		getRestaurant(restaurantId);
		getMenu(menuId);
		menuRepository.delete(menuId);
	}

	public void addSubMenu(long menuId, long subMenuId) {
		Menu m = getMenu(menuId);
		m.getSubMenus().add(getSubMenu(subMenuId));
		menuRepository.saveAndFlush(m);
	}
	
	public void deleteSubMenu(long menuId, long subMenuId) {
		Menu m = getMenu(menuId);
		m.getSubMenus().removeIf(s->s.getSubMenuId()==subMenuId);
		menuRepository.saveAndFlush(m);
	}
	
	private Restaurant getRestaurant(String restaurantId) {
		Restaurant r = restaurantRepository.findOne(restaurantId);
		if (r == null) throw new ResourceNotFoundException("Restaurant Not Found");
		return r;
		
	}
	private Menu getMenu(long menuId) {
		Menu m = menuRepository.findOne(menuId);
		if (m == null) throw new ResourceNotFoundException("Menu Not Found");
		return m;
	}
	
	private SubMenu getSubMenu(long subMenuId) {
		SubMenu s = subMenuRepository.findOne(subMenuId);
		if (s == null) throw new ResourceNotFoundException("SubMenu Not Found");
		return s;
	}

}
