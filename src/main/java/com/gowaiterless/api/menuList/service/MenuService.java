package com.gowaiterless.api.menuList.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.menuList.Menu;
import com.gowaiterless.api.menuList.MenuId;
import com.gowaiterless.api.menuList.MenuSequences;
import com.gowaiterless.api.menuList.Restaurant;
import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.SubMenuId;
import com.gowaiterless.api.menuList.repository.MenuRepository;
import com.gowaiterless.api.menuList.repository.MenuSequencesRepository;
import com.gowaiterless.api.menuList.repository.RestaurantRepository;
import com.gowaiterless.api.menuList.repository.SubMenuRepository;
import com.gowaiterless.exception.BadInputException;
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
		return menuRepository.findByMenuIdRestaurantId(resId).orElseThrow(()->new ResourceNotFoundException());
	}
	
	public Menu getMenu(String restaurantId, long id) {
		Restaurant r = getRestaurant(restaurantId);
		return menuRepository.findOne(new MenuId(r, id));
	}
	
	public Menu addMenu(String restaurantId, Menu m) {
		
		Restaurant r = getRestaurant(restaurantId);
		m.getMenuId().setRestaurant(r);
		if (existRestaurantMenuCode(m)!=null) throw new BadInputException("Duplicated Menu Code");
		MenuSequences next = menuSequencesRepository.getOne(restaurantId+"_menu");
		m.getMenuId().setMenuNum(next.getCount());
		next.setCount(next.getCount()+1);
		menuSequencesRepository.saveAndFlush(next);
		menuRepository.saveAndFlush(m);
		return m;
	}
	
	public Menu updateMenu(String restaurantId, long menuId, Menu m) {
		Restaurant r = getRestaurant(restaurantId);
		//menu exists
		getMenu(restaurantId, menuId);
		m.getMenuId().setRestaurant(r);
		//Menu Code must be unique in a restaurant
		Menu t = existRestaurantMenuCode(m);
		m.setMenuId(new MenuId(r, menuId));
		if (t!=null && t.getMenuId().getMenuNum() != m.getMenuId().getMenuNum()) throw new BadInputException("Duplicated Menu Code");

		menuRepository.saveAndFlush(m);
		return m;
	}
	
	public void deleteMenu(String restaurantId, long menuId) {
		Restaurant r = getRestaurant(restaurantId);
		getMenu(restaurantId, menuId);
		menuRepository.delete(new MenuId(r, menuId));
	}

	public void addSubMenu(String restaurantId, long menuId, long subMenuId) {
		Menu m = getMenu(restaurantId, menuId);
		m.getSubMenus().add(getSubMenu(restaurantId,subMenuId));
		menuRepository.saveAndFlush(m);
	}
	
	public void deleteSubMenu(String restaurantId, long menuId, long subMenuId) {
		Menu m = getMenu(restaurantId, menuId);
		m.getSubMenus().removeIf(s->s.getSubMenuId().getSubMenuNum()==subMenuId&&s.getSubMenuId().getRestaurant().getId()==restaurantId);
		menuRepository.saveAndFlush(m);
	}
	
	private Restaurant getRestaurant(String restaurantId) {
		Restaurant r = restaurantRepository.findOne(restaurantId);
		if (r == null) throw new ResourceNotFoundException("Restaurant Not Found");
		return r;
		
	}
	
	
	private SubMenu getSubMenu(String restaurantId, long subMenuId) {
		SubMenu s = subMenuRepository.findOne(new SubMenuId(getRestaurant(restaurantId),subMenuId));
		if (s == null) throw new ResourceNotFoundException("SubMenu Not Found");
		return s;
	}
	
	private Menu existRestaurantMenuCode(Menu m) {
		return menuRepository.findByMenuIdRestaurantIdAndMenuCode(m.getMenuId().getRestaurant().getId(), m.getMenuCode());
	}

}
