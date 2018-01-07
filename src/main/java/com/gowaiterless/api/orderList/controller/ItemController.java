package com.gowaiterless.api.orderList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gowaiterless.api.orderList.Item;
import com.gowaiterless.api.orderList.service.ItemService;

@RestController
@RequestMapping("restaurant/{restaurantid}/order/{orderid}/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Item> getItems(@PathVariable String restaurantid, @PathVariable long orderid) {
		return itemService.getItems(restaurantid, orderid);
	}
	
	@RequestMapping(value="/{itemid}",method=RequestMethod.GET)
	public Item getItem(@PathVariable String restaurantid, @PathVariable long orderid,@PathVariable int itemid) {
		return itemService.getItem(restaurantid, orderid, itemid);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Item> setItem(@PathVariable String restaurantid, @PathVariable long orderid, @RequestBody Item item) {
		return ResponseEntity.status(HttpStatus.CREATED).body(itemService.setItem(restaurantid, orderid, item));
	}
	
	@RequestMapping(value="/{itemid}",method=RequestMethod.PUT)
	public Item updateItem(@PathVariable String restaurantid, @PathVariable long orderid,  @PathVariable int itemid, @RequestBody Item item) {
		return itemService.updateItem(restaurantid, orderid, itemid, item);
	}
	
	@RequestMapping(value="/{itemid}",method=RequestMethod.DELETE)
	public List<Item> deleteItem(@PathVariable String restaurantid, @PathVariable long orderid,  @PathVariable int itemid) {
		return itemService.deleteItem(restaurantid, orderid, itemid);
	}
}
