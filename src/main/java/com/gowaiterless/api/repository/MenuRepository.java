package com.gowaiterless.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gowaiterless.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {
	public List<Menu> findByRestaurantId(String id);
}
