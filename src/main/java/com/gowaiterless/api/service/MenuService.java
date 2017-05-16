package com.gowaiterless.api.service;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.Menu;
import com.gowaiterless.Restaurant;
import com.gowaiterless.SubMenu;
import com.gowaiterless.api.repository.MenuRepository;
import com.gowaiterless.api.repository.RestaurantRepository;
import com.gowaiterless.exception.ResourceNotFoundException;

@Service
@Transactional
public class MenuService {
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public List<Menu> getMenus(String resId) {
		return menuRepository.findByRestaurantId(resId).orElseThrow(()->new ResourceNotFoundException());
	}
	
	public Menu getMenu(String restaurantId, long id) {
		checkRestaurant(restaurantId);
		return menuRepository.findOne(id);
	}
	
	public Menu addMenu(String restaurantId, Menu m) {
		checkRestaurant(restaurantId);
		m.setRestaurant(new Restaurant(restaurantId));
		menuRepository.saveAndFlush(m);
		return m;
	}
	
	public Menu updateMenu(String restaurantId, long menuId, Menu m) {
		checkRestaurant(restaurantId);
		checkMenu(menuId);
		m.setRestaurant(new Restaurant(restaurantId));
		m.setMenuId(menuId);
		menuRepository.saveAndFlush(m);
		return m;
	}
	
	public void deleteMenu(String restaurantId, long menuId) {
		checkRestaurant(restaurantId);
		checkMenu(menuId);
		menuRepository.delete(menuId);
	}

	public void addSubMenu(long menuId, long subMenuId) {
		Menu m = checkMenu(menuId);
		m.getSubMenus().add(new SubMenu(subMenuId));
		menuRepository.save(m);
	}
	
	public void deleteSubMenu(long menuId, long subMenuId) {
		Menu m = checkMenu(menuId);
		m.getSubMenus().removeIf(s->s.getSubMenuId()==subMenuId);
		menuRepository.save(m);
	}
	
	private Restaurant checkRestaurant(String restaurantId) {
		Restaurant r = restaurantRepository.findOne(restaurantId);
		if (r == null) throw new ResourceNotFoundException("Restaurant Not Found");
		return r;
		
	}
	private Menu checkMenu(long menuId) {
		Menu m = menuRepository.findOne(menuId);
		if (m == null) throw new ResourceNotFoundException("Menu Not Found");
		return m;
	}

}
