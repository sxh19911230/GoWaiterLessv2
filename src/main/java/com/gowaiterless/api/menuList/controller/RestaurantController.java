package com.gowaiterless.api.menuList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gowaiterless.api.file.service.FileService;
import com.gowaiterless.api.menuList.MenuBook;
import com.gowaiterless.api.menuList.Restaurant;
import com.gowaiterless.api.menuList.service.RestaurantService;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	FileService fileService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Restaurant> getRestaurants(){
		return restaurantService.getRestaurants();
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Restaurant getRestaurant(@PathVariable String id){
		return restaurantService.getRestaurant(id);
	}
	
	@RequestMapping(value="/{id}/uploadpic",method=RequestMethod.POST)
	public String uploadPic(@PathVariable String id, @RequestParam("pictureFile") MultipartFile uploadfile){
		//TODO Linux save file path
		return "{name:"+fileService.saveFile("C:\\Users\\Forrest\\Desktop\\",id, uploadfile) +"}";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.addRestaurant(restaurant));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Restaurant updateRestaurant(@PathVariable String id, @RequestBody Restaurant restaurant) {
		return restaurantService.updateRestaurant(id, restaurant);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteRestaurant(@PathVariable String id) {
		restaurantService.deleteRestaurant(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/{id}/menubook",method=RequestMethod.POST)
	public Restaurant addMenuBook(@PathVariable String id, @RequestBody MenuBook menuBook) {
		return restaurantService.addMenuBook(id, menuBook.getId());
	}
	
	@RequestMapping(value="/{id}/menubook",method=RequestMethod.DELETE)
	public Restaurant deleteMenuBook(@PathVariable String id) {
		return restaurantService.deleteMenuBook(id);
	}
}
