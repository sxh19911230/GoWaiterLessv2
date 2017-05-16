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

import com.gowaiterless.Menu;
import com.gowaiterless.api.service.MenuService;


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
		m.setMenuId(0);
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
	@RequestMapping(value="/{menuId}/addsubmenu/{subMenuId}",method=RequestMethod.POST)
	public ResponseEntity<?> addSubMenu(@PathVariable long menuId, @PathVariable long subMenuId) {
		menuService.addSubMenu(menuId,subMenuId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/{menuId}/removesubmenu/{subMenuId}",method=RequestMethod.POST)
	public ResponseEntity<?> deleteSubMenu(@PathVariable long menuId, @PathVariable long subMenuId) {
		menuService.deleteSubMenu(menuId,subMenuId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
