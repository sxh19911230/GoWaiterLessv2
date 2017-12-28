package com.gowaiterless.api.menuList.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowaiterless.api.menuList.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	public Optional<List<Menu>> findByRestaurantId(String id);
}
