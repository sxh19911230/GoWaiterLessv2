package com.gowaiterless.api.menuList.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowaiterless.api.menuList.Menu;
import com.gowaiterless.api.menuList.MenuId;

public interface MenuRepository extends JpaRepository<Menu, MenuId> {
	public Optional<List<Menu>> findByMenuIdRestaurantId(String id);
	public Menu findByMenuIdRestaurantIdAndMenuCode(String id, String menuCode);
}
