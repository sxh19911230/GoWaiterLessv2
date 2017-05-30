package com.gowaiterless.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.Restaurant;
import com.gowaiterless.api.repository.RestaurantRepository;
import com.gowaiterless.exception.ResourceDuplicationException;
import com.gowaiterless.exception.ResourceNotFoundException;

@Service
@Transactional
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantReprository;

	public List<Restaurant> getRestaurants() {
		List<Restaurant> r = new ArrayList<Restaurant>();
		restaurantReprository.findAll().forEach(t->r.add(t));
		return r;
	}
	public Restaurant getRestaurant(String restaurantId) {
		Restaurant r = restaurantReprository.findOne(restaurantId);
		if (r == null) throw new ResourceNotFoundException();
		return r;
	}
	public Restaurant addRestaurant(Restaurant r) {
		Restaurant t = restaurantReprository.findOne(r.getId());
		if (t != null) throw new ResourceDuplicationException();;
		restaurantReprository.saveAndFlush(r);
		return r;
	}
	public Restaurant updateRestaurant(String restaurantId, Restaurant r) {
		getRestaurant(restaurantId);
		r.setId(restaurantId);
		restaurantReprository.saveAndFlush(r);
		return r;
	}
	public void deleteRestaurant(String id) {
		getRestaurant(id);
		restaurantReprository.delete(id);
	}
	
	
}
