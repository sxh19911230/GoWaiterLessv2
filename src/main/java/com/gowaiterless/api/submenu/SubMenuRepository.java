package com.gowaiterless.api.submenu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SubMenuRepository extends CrudRepository<SubMenu, Long>{
	public List<SubMenu> findByMenusMenuId(long menuId);
}
