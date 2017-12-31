package com.gowaiterless.api.menuList.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gowaiterless.api.menuList.Menu;
import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.service.MenuService;


@RestController
@RequestMapping("restaurant/{restaurantId}/menu")
public class MenuController {
	@Autowired
	MenuService menuService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Menu> getMenus(@PathVariable String restaurantId) {
		return menuService.getMenus(restaurantId);
	}
	
	@RequestMapping(value="/{menuId}", method=RequestMethod.GET) 
	public Menu getMenu(@PathVariable String restaurantId, @PathVariable long menuId){
		return menuService.getMenu(restaurantId, menuId);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Menu> addMenu(@RequestBody Menu m, @PathVariable String restaurantId) {
		return ResponseEntity.status(HttpStatus.CREATED).body(menuService.addMenu(restaurantId, m));
	}
	@RequestMapping(value="/{menuId}", method=RequestMethod.PUT)
	public Menu updateMenu(@RequestBody Menu m, @PathVariable String restaurantId, @PathVariable long menuId) {
		return menuService.updateMenu(restaurantId, menuId, m);
	}
	@RequestMapping(value="/{menuId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteMenu(@PathVariable String restaurantId, @PathVariable long menuId) {
		menuService.deleteMenu(restaurantId, menuId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value="/{menuId}/submenu",method=RequestMethod.POST)
	public ResponseEntity<?> addSubMenu(@PathVariable String restaurantId, @PathVariable long menuId, @RequestBody SubMenu subMenu) {
		menuService.addSubMenu(restaurantId,menuId,subMenu.getSubMenuId());
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/{menuId}/submenu",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteSubMenu(@PathVariable String restaurantId, @PathVariable long menuId, @RequestBody SubMenu subMenu) {
		menuService.deleteSubMenu(restaurantId, menuId,subMenu.getSubMenuId());
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}