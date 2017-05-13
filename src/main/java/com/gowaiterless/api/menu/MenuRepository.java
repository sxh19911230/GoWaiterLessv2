package com.gowaiterless.api.menu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {
	public List<Menu> findByRestaurantId(String id);
}
