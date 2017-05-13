package com.gowaiterless.api.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepository;
	
	List<Menu> getMenus(String resId) {
		return menuRepository.findByRestaurantId(resId);
	}
	
	Menu getMenu(long id) {
		return menuRepository.findOne(id);
	}
	
	void addMenu(Menu m) {
		menuRepository.save(m);
	}
	
	void updateMenu(Menu m) {
		menuRepository.save(m);
	}
	
	void deleteMenu(long id) {
		menuRepository.delete(id);
	}

}
