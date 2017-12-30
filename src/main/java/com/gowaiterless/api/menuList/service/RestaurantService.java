package com.gowaiterless.api.menuList.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.menuList.MenuSequences;
import com.gowaiterless.api.menuList.Restaurant;
import com.gowaiterless.api.menuList.repository.MenuSequencesRepository;
import com.gowaiterless.api.menuList.repository.RestaurantRepository;
import com.gowaiterless.exception.ResourceDuplicationException;
import com.gowaiterless.exception.ResourceNotFoundException;

@Service
@Transactional
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantReprository;
	@Autowired
	MenuSequencesRepository menuSequencesRepository;

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
		if (t != null) throw new ResourceDuplicationException();
		menuSequencesRepository.saveAndFlush(new MenuSequences(r.getId()+"_menu",1));
		menuSequencesRepository.saveAndFlush(new MenuSequences(r.getId()+"_submenu",1));
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
		menuSequencesRepository.delete(id+"_menu");
		menuSequencesRepository.delete(id+"_submenu");
	}
	
	
}
