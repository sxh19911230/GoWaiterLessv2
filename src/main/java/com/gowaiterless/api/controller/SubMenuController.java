package com.gowaiterless.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gowaiterless.api.SubMenu;
import com.gowaiterless.api.service.SubMenuService;

@RestController
@RequestMapping("restaurant/{restaurantId}/")
public class SubMenuController {
	@Autowired
	SubMenuService subMenuService;
	
	@RequestMapping(value="menu/{menuId}/submenu", method=RequestMethod.GET)
	public List<SubMenu> getMenuSubMenus(@PathVariable String restaurantId, @PathVariable long menuId) {
		return subMenuService.getSubMenus(restaurantId, menuId);
	}
	
	@RequestMapping(value="submenu/{subMenuId}", method=RequestMethod.GET)
	public SubMenu getSubMenu(@PathVariable String restaurantId, @PathVariable long subMenuId) {
		return subMenuService.getSubMenu(restaurantId, subMenuId);
	}
	
	@RequestMapping(value="submenu", method=RequestMethod.GET)
	public List<SubMenu> getRestaurantSubMenus(@PathVariable String restaurantId) {
		return subMenuService.getSubMenus(restaurantId);
	}
	
	@RequestMapping(value="submenu", method=RequestMethod.POST)
	public ResponseEntity<SubMenu> addSubMenu(@PathVariable String restaurantId, @RequestBody SubMenu subMenu) {
		return ResponseEntity.status(HttpStatus.CREATED).body(subMenuService.addSubMenu(restaurantId, subMenu));
	}
	
	@RequestMapping(value="submenu/{subMenuId}", method=RequestMethod.PUT)
	public SubMenu updateMenu(@PathVariable String restaurantId,@PathVariable long subMenuId, @RequestBody SubMenu subMenu) {
		return subMenuService.updateSubMenu(restaurantId, subMenuId, subMenu);
	}
	
	@RequestMapping(value="submenu/{subMenuId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteMenu(@PathVariable String restaurantId, @PathVariable long subMenuId) {
		subMenuService.deleteSubMenu(restaurantId, subMenuId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	

}
