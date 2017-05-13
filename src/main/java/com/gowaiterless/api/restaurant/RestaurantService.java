package com.gowaiterless.api.restaurant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantReprository;

	public List<Restaurant> getRestaurants() {
		List<Restaurant> r = new ArrayList<Restaurant>();
		restaurantReprository.findAll().forEach(t->r.add(t));
		return r;
	}
	public Restaurant getRestaurant(String id) {
		return restaurantReprository.findOne(id);
	}
	public void addRestaurant(Restaurant r) {
		restaurantReprository.save(r);
	}
	public void updateRestaurant(Restaurant r) {
		restaurantReprository.save(r);
	}
	public void deleteRestaurant(String id) {
		restaurantReprository.delete(id);
	}
}
