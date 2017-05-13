package com.gowaiterless.api.submenu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubMenuService {
	@Autowired
	SubMenuRepository subMenuRepository;
	
	public List<SubMenu> getSubMenus(long menuId) {
		return subMenuRepository.findByMenusMenuId(menuId);
	}
	public SubMenu getSubMenu(long id) {
		return subMenuRepository.findOne(id);
	}
	public void addSubMenu(SubMenu s) {
		subMenuRepository.save(s);
	}
	public void updateSubMenu(SubMenu s) {
		subMenuRepository.save(s);
	}
	public void deleteSubMenu(long id) {
		subMenuRepository.delete(id);
	}

}
