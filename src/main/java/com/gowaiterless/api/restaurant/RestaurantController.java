package com.gowaiterless.api.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@RequestMapping(method=RequestMethod.GET)
	List<Restaurant> getRestaurants(){
		return restaurantService.getRestaurants();
	}
	@RequestMapping(value="/{restaurantId}",method=RequestMethod.GET)
	Restaurant getRestaurant(@PathVariable String restaurantId){
		return restaurantService.getRestaurant(restaurantId);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	String addRestaurant(@RequestBody Restaurant restaurant) {
		restaurantService.addRestaurant(restaurant);
		return "success";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	String updateRestaurant(@RequestBody Restaurant restaurant) {
		restaurantService.updateRestaurant(restaurant);
		return "success";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	String deleteRestaurant(@PathVariable String id) {
		restaurantService.deleteRestaurant(id);
		return "success";
	}
}
