package com.gowaiterless.api.menuList.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.exception.BadInputException;
import com.gowaiterless.api.exception.ResourceNotFoundException;
import com.gowaiterless.api.menuList.Choice;
import com.gowaiterless.api.menuList.MenuBook;
import com.gowaiterless.api.menuList.MenuId;
import com.gowaiterless.api.menuList.Sequences;
import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.SubMenuId;
import com.gowaiterless.api.menuList.repository.MenuBookRepository;
import com.gowaiterless.api.menuList.repository.SequencesRepository;
import com.gowaiterless.api.menuList.repository.SubMenuRepository;


@Service
@Transactional
public class SubMenuService {
	@Autowired
	SubMenuRepository subMenuRepository;
	@Autowired
	MenuBookRepository menuBookRepository;
	@Autowired
	SequencesRepository sequencesRepository;
	
	public List<SubMenu> getSubMenus(long menubookid, long menuId) {
		return subMenuRepository.findBySubMenuIdMenuBookMenus(new MenuId(getMenuBook(menubookid), menuId)).orElseThrow(()->new ResourceNotFoundException());
	}

	public SubMenu addSubMenu(long menubookid, SubMenu s) {
		
		MenuBook mb = getMenuBook(menubookid);
		s.getSubMenuId().setMenuBook(mb);
		assignChoiceId(s);
		Sequences next = sequencesRepository.getOne(menubookid+"_submenu");
		s.getSubMenuId().setSubMenuNum(next.getNext());
		next.setNext(next.getNext()+1);
		sequencesRepository.saveAndFlush(next);
		subMenuRepository.saveAndFlush(s);
		return s;
	}
	

	public SubMenu updateSubMenu(long menubookid, long subMenuId, SubMenu s) {
		
		getSubMenu(menubookid, subMenuId);
		s.getSubMenuId().setSubMenuNum(subMenuId);
		s.getSubMenuId().setMenuBook(getMenuBook(menubookid));
		assignChoiceId(s);
		subMenuRepository.saveAndFlush(s);
		return s;
	}
	public void deleteSubMenu(long menubookid, long subMenuId) {
		getMenuBook(menubookid);
		subMenuRepository.delete(getSubMenu(menubookid, subMenuId));
	}
	public List<SubMenu> getSubMenus(long menubookid) {
		getMenuBook(menubookid);
		return subMenuRepository.findBySubMenuIdMenuBookId(menubookid).orElseThrow(()->new ResourceNotFoundException());
	}
	
	private MenuBook getMenuBook(long menubookid) {
		MenuBook mb = menuBookRepository.findOne(menubookid);
		if(mb==null) throw new ResourceNotFoundException();
		return mb;
	}
	
	public SubMenu getSubMenu(long menubookid, long subMenuId) {
		SubMenu s = subMenuRepository.findOne(new SubMenuId(getMenuBook(menubookid),subMenuId));
		if(s==null) throw new ResourceNotFoundException();
		return s;
	}
	
	private void assignChoiceId(SubMenu s) {
		Sequences seq = sequencesRepository.getOne(s.getSubMenuId().getMenuBook().getId()+"_choice");
		int next = seq.getNext();
		for ( Choice c : s.getChoices())
			if (c.getId() == 0) c.setId(next++);
		seq.setNext(next);
		sequencesRepository.save(seq);
		
	}

}
