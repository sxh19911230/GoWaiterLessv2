package com.gowaiterless.api.restaurant;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
	@RequestMapping(value="/api/v1/restaurants/", method=RequestMethod.GET)
	List<Restaurant> getRestaurants(){
		return Arrays.asList(new Restaurant());
	}
	@RequestMapping(value="/api/v1/restaurants/{restaurantId}/",method=RequestMethod.GET)
	Restaurant getRestaurant(@PathVariable String restaurantId){
		return new Restaurant();
	}
	
	@RequestMapping(value="/api/v1/restaurants/",method=RequestMethod.POST)
	String setRestaurant(@RequestBody Restaurant restaurant) {
		return "successfull";
	}
}
