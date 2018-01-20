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
@RequestMapping("menubook/{menubookid}/menu")
public class MenuController {
	@Autowired
	MenuService menuService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Menu> getMenus(@PathVariable long menubookid) {
		return menuService.getMenus(menubookid);
	}
	
	@RequestMapping(value="/{menuId}", method=RequestMethod.GET) 
	public Menu getMenu(@PathVariable long menubookid, @PathVariable long menuId){
		return menuService.getMenu(menubookid, menuId);
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Menu> addMenu(@RequestBody Menu m, @PathVariable long menubookid) {
		return ResponseEntity.status(HttpStatus.CREATED).body(menuService.addMenu(menubookid, m));
	}
	@RequestMapping(value="/{menuId}", method=RequestMethod.PUT)
	public Menu updateMenu(@RequestBody Menu m, @PathVariable long menubookid, @PathVariable long menuId) {
		return menuService.updateMenu(menubookid, menuId, m);
	}
	@RequestMapping(value="/{menuId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteMenu(@PathVariable long menubookid, @PathVariable long menuId) {
		menuService.deleteMenu(menubookid, menuId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	//Set submenus
	@RequestMapping(value="/{menuId}/submenu",method=RequestMethod.POST)
	public ResponseEntity<?> addSubMenus(@PathVariable long menubookid, @PathVariable long menuId, @RequestBody SubMenu [] subMenus) {
		menuService.addSubMenus(menubookid,menuId,subMenus);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	//Delete submenus
	@RequestMapping(value="/{menuId}/submenu",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteSubMenu(@PathVariable long menubookid, @PathVariable long menuId) {
		menuService.deleteSubMenus(menubookid, menuId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
