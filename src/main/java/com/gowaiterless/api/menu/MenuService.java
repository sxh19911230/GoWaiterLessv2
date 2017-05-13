package com.gowaiterless.api.menu;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.submenu.SubMenu;

@Service
@Transactional
public class MenuService {
	@Autowired
	MenuRepository menuRepository;
	
	public List<Menu> getMenus(String resId) {
		return menuRepository.findByRestaurantId(resId);
	}
	
	public Menu getMenu(long id) {
		return menuRepository.findOne(id);
	}
	
	public void addMenu(Menu m) {
		menuRepository.save(m);
	}
	
	public void updateMenu(Menu m) {
		menuRepository.save(m);
	}
	
	public void deleteMenu(long id) {
		menuRepository.delete(id);
	}

	public void addSubMenu(long menuId, long subMenuId) {
		Menu m = menuRepository.findOne(menuId);
		m.getSubMenus().add(new SubMenu(subMenuId));
		menuRepository.save(m);
	}
	
	public void deleteSubMenu(long menuId, long subMenuId) {
		Menu m = menuRepository.findOne(menuId);
		m.getSubMenus().removeIf(s->s.getSubMenuId()==subMenuId);
		menuRepository.save(m);
	}

}
