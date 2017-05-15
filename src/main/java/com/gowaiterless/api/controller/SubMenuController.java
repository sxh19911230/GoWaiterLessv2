package com.gowaiterless.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gowaiterless.SubMenu;
import com.gowaiterless.api.service.SubMenuService;

@RestController
@RequestMapping("restaurant/{restaurantId}/")
public class SubMenuController {
	@Autowired
	SubMenuService subMenuService;
	
	@RequestMapping(value="menu/{menuId}/submenu", method=RequestMethod.GET)
	List<SubMenu> getMenuSubMenus(@PathVariable long menuId) {
		return subMenuService.getSubMenus(menuId);
	}
	
	@RequestMapping(value="submenu/{subMenuId}", method=RequestMethod.GET)
	SubMenu getSubMenu(@PathVariable long subMenuId) {
		return subMenuService.getSubMenu(subMenuId);
	}
	
	@RequestMapping(value="submenu", method=RequestMethod.GET)
	List<SubMenu> getRestaurantSubMenus(@PathVariable String restaurantId) {
		return subMenuService.getSubMenus(restaurantId);
	}
	
	@RequestMapping(value="submenu", method=RequestMethod.POST)
	String addSubMenu(@PathVariable String restaurantId, @RequestBody SubMenu subMenu) {
		subMenuService.addSubMenu(restaurantId, subMenu);
		return "success";
	}
	
	@RequestMapping(value="submenu/{subMenuId}", method=RequestMethod.PUT)
	String updateMenu(@PathVariable String restaurantId, @RequestBody SubMenu subMenu) {
		subMenuService.addSubMenu(restaurantId, subMenu);
		return "success";
	}
	
	@RequestMapping(value="submenu/{subMenuId}", method=RequestMethod.DELETE)
	String deleteMenu(@PathVariable long subMenuId) {
		subMenuService.deleteSubMenu(subMenuId);
		return "success";
	}
	

}
