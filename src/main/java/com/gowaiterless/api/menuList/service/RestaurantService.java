package com.gowaiterless.api.menuList.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.menuList.MenuBook;
import com.gowaiterless.api.menuList.Restaurant;
import com.gowaiterless.api.menuList.Sequences;
import com.gowaiterless.api.menuList.repository.MenuBookRepository;
import com.gowaiterless.api.menuList.repository.SequencesRepository;
import com.gowaiterless.api.menuList.repository.RestaurantRepository;
import com.gowaiterless.exception.ResourceDuplicationException;
import com.gowaiterless.exception.ResourceNotFoundException;

@Service
@Transactional
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantReprository;
	@Autowired
	SequencesRepository sequencesRepository;
	@Autowired
	MenuBookRepository menuBookRepository;
	

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
		
		sequencesRepository.saveAndFlush(new Sequences(r.getId()+"_order",1));
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
		sequencesRepository.delete(id+"_order");
		restaurantReprository.delete(id);

	}
	public Restaurant addMenuBook(String id, MenuBook menuBook) {
		Restaurant r = getRestaurant(id);
		r.setMenuBook(menuBookRepository.getOne(menuBook.getId()));
		restaurantReprository.saveAndFlush(r);
		return r;
	}
	public Restaurant deleteMenuBook(String id) {
		Restaurant r = getRestaurant(id);
		r.setMenuBook(null);
		restaurantReprository.saveAndFlush(r);
		return r;
	}
	
	
}
