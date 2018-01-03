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

import com.gowaiterless.api.menuList.MenuBook;
import com.gowaiterless.api.menuList.service.MenuBookService;

@RestController
@RequestMapping("menubook")
public class MenuBookController {
	@Autowired
	MenuBookService menuBookService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<MenuBook> getMenuBooks(){
		return menuBookService.getMenuBooks();
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public MenuBook getMenuBook(@PathVariable long id){
		return menuBookService.getMenuBook(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<MenuBook> addMenuBook(@RequestBody MenuBook menuBook) {
		return ResponseEntity.status(HttpStatus.CREATED).body(menuBookService.addMenuBook(menuBook));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public MenuBook updateMenuBook(@PathVariable long id, @RequestBody MenuBook menuBook) {
		return menuBookService.updateMenuBook(id, menuBook);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteMenuBook(@PathVariable long id) {
		menuBookService.deleteMenuBook(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
}
