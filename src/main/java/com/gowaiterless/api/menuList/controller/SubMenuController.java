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

import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.service.SubMenuService;

@RestController
@RequestMapping("menubook/{menubookid}/")
public class SubMenuController {
	@Autowired
	SubMenuService subMenuService;
	
	@RequestMapping(value="menu/{menuId}/submenu", method=RequestMethod.GET)
	public List<SubMenu> getMenuSubMenus(@PathVariable long menubookid, @PathVariable long menuId) {
		return subMenuService.getSubMenus(menubookid, menuId);
	}
	
	@RequestMapping(value="submenu/{subMenuId}", method=RequestMethod.GET)
	public SubMenu getSubMenu(@PathVariable long menubookid, @PathVariable long subMenuId) {
		return subMenuService.getSubMenu(menubookid, subMenuId);
	}
	
	@RequestMapping(value="submenu", method=RequestMethod.GET)
	public List<SubMenu> getMenuBookSubMenus(@PathVariable long menubookid) {
		return subMenuService.getSubMenus(menubookid);
	}
	
	@RequestMapping(value="submenu", method=RequestMethod.POST)
	public ResponseEntity<SubMenu> addSubMenu(@PathVariable long menubookid, @RequestBody SubMenu subMenu) {
		return ResponseEntity.status(HttpStatus.CREATED).body(subMenuService.addSubMenu(menubookid, subMenu));
	}
	
	@RequestMapping(value="submenu/{subMenuId}", method=RequestMethod.PUT)
	public SubMenu updateMenu(@PathVariable long menubookid,@PathVariable long subMenuId, @RequestBody SubMenu subMenu) {
		return subMenuService.updateSubMenu(menubookid, subMenuId, subMenu);
	}
	@RequestMapping(value="submenu/{subMenuId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteMenu(@PathVariable long menubookid, @PathVariable long subMenuId) {
		subMenuService.deleteSubMenu(menubookid, subMenuId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	

}
