package com.gowaiterless.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gowaiterless.Menu;
import com.gowaiterless.Restaurant;
import com.gowaiterless.api.Service.MenuService;


@RestController
@RequestMapping("restaurant/{restaurantId}/menu")
public class MenuController {
	@Autowired
	MenuService menuService;
	
	@RequestMapping(method=RequestMethod.GET)
	List<Menu> getMenus(@PathVariable String restaurantId) {
		return menuService.getMenus(restaurantId);
	}
	
	@RequestMapping(value="/{menuId}", method=RequestMethod.GET) 
	Menu getMenu(@PathVariable long menuId){
		return menuService.getMenu(menuId);
	}
	@RequestMapping(method=RequestMethod.POST)
	String addMenu(@RequestBody Menu m, @PathVariable String restaurantId) {
		m.setRestaurant(new Restaurant(restaurantId));
		menuService.addMenu(m);
		return "success";
	}
	
	@RequestMapping(value="/{menuId}", method=RequestMethod.PUT)
	String updateMenu(@RequestBody Menu m, @PathVariable String restaurantId) {
		m.setRestaurant(new Restaurant(restaurantId));
		
		menuService.updateMenu(m);
		return "success";
	}
	@RequestMapping(value="/{menuId}", method=RequestMethod.DELETE)
	String deleteMenu(@PathVariable long menuId) {
		menuService.deleteMenu(menuId);
		return "success";
	}
	@RequestMapping(value="/{menuId}/submenu/{subMenuId}",method=RequestMethod.POST)
	String addSubMenu(@PathVariable long menuId, @PathVariable long subMenuId) {
		menuService.addSubMenu(menuId,subMenuId);
		return "success";
	}
	
	@RequestMapping(value="/{menuId}/submenu/{subMenuId}",method=RequestMethod.DELETE)
	String deleteSubMenu(@PathVariable long menuId, @PathVariable long subMenuId) {
		menuService.deleteSubMenu(menuId,subMenuId);
		return "success";
	}
	

}
