package com.gowaiterless.api.menuList.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.exception.BadInputException;
import com.gowaiterless.api.exception.ResourceNotFoundException;
import com.gowaiterless.api.menuList.Menu;
import com.gowaiterless.api.menuList.MenuBook;
import com.gowaiterless.api.menuList.MenuId;
import com.gowaiterless.api.menuList.Sequences;
import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.SubMenuId;
import com.gowaiterless.api.menuList.repository.MenuBookRepository;
import com.gowaiterless.api.menuList.repository.MenuRepository;
import com.gowaiterless.api.menuList.repository.SequencesRepository;
import com.gowaiterless.api.menuList.repository.SubMenuRepository;

@Service
@Transactional
public class MenuService {
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	MenuBookRepository menuBookRepository;
	@Autowired
	SubMenuRepository subMenuRepository;
	@Autowired
	SequencesRepository sequencesRepository;
	
	public List<Menu> getMenus(long menubookid) {
		return menuRepository.findByMenuIdMenuBookId(menubookid).orElseThrow(()->new ResourceNotFoundException());
	}
	
	public Menu getMenu(long menuBookId, long id) {
		MenuBook m = getMenuBook(menuBookId);
		return menuRepository.findOne(new MenuId(m, id));
	}
	
	public Menu addMenu(long menubookid, Menu m) {
		
		MenuBook mb = getMenuBook(menubookid);
		m.getMenuId().setMenuBook(mb);
		for(SubMenu s : m.getSubMenus())
			s.getSubMenuId().setMenuBook(mb);
		
		if (existMenuBookMenuCode(m)!=null) throw new BadInputException("Duplicated Menu Code");
		Sequences next = sequencesRepository.getOne(menubookid+"_menu");
		m.getMenuId().setMenuNum(next.getNext());
		next.setNext(next.getNext()+1);
		sequencesRepository.saveAndFlush(next);
		menuRepository.saveAndFlush(m);
		return m;
	}
	
	public Menu updateMenu(long menubookid, long menuId, Menu m) {
		MenuBook mb = getMenuBook(menubookid);
		//menu exists
		getMenu(menubookid, menuId);
		m.getMenuId().setMenuBook(mb);
		//set submenu bookid
		for(SubMenu s : m.getSubMenus())
			s.getSubMenuId().setMenuBook(mb);
		//Menu Code must be unique in a restaurant
		Menu t = existMenuBookMenuCode(m);
		m.setMenuId(new MenuId(mb, menuId));
		if (t!=null && t.getMenuId().getMenuNum() != m.getMenuId().getMenuNum()) throw new BadInputException("Duplicated Menu Code");

		menuRepository.saveAndFlush(m);
		return m;
	}
	
	public void deleteMenu(long menubookid, long menuId) {
		MenuBook m = getMenuBook(menubookid);
		getMenu(menubookid, menuId);
		menuRepository.delete(new MenuId(m, menuId));
	}

	public void addSubMenus(long menukoobid, long menuId, SubMenu [] subMenus) {
		Menu m = getMenu(menukoobid, menuId);
		MenuBook mb = new MenuBook(menukoobid);
		for (SubMenu s : subMenus) {
			s.getSubMenuId().setMenuBook(mb);
		}
		m.setSubMenus(new HashSet<SubMenu>(Arrays.asList(subMenus)));
		menuRepository.saveAndFlush(m);
	}
	
	public void deleteSubMenus(long menubookid, long menuId) {
		Menu m = getMenu(menubookid, menuId);
		m.getSubMenus().clear();
		menuRepository.saveAndFlush(m);
	}
	
	private MenuBook getMenuBook(long menuBookId) {
		MenuBook m = menuBookRepository.findOne(menuBookId);
		if (m == null) throw new ResourceNotFoundException("Restaurant Not Found");
		return m;
		
	}
	
	
	private SubMenu getSubMenu(long menukoobid, long subMenuId) {
		SubMenu s = subMenuRepository.findOne(new SubMenuId(getMenuBook(menukoobid),subMenuId));
		if (s == null) throw new ResourceNotFoundException("SubMenu Not Found");
		return s;
	}
	
	private Menu existMenuBookMenuCode(Menu m) {
		return menuRepository.findByMenuIdMenuBookIdAndMenuCode(m.getMenuId().getMenuBook().getId(), m.getMenuCode());
	}

}
