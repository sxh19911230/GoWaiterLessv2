package com.gowaiterless.api.menuList.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.menuList.MenuBook;
import com.gowaiterless.api.menuList.MenuSequences;
import com.gowaiterless.api.menuList.repository.MenuBookRepository;
import com.gowaiterless.api.menuList.repository.MenuSequencesRepository;
import com.gowaiterless.exception.ResourceNotFoundException;

@Service
@Transactional
public class MenuBookService {
	@Autowired
	private MenuBookRepository menuBookRepository;
	@Autowired
	private MenuSequencesRepository menuSequencesRepository;

	public List<MenuBook> getMenuBooks() {
		List<MenuBook> mbs=new ArrayList<MenuBook>();
		menuBookRepository.findAll().forEach(mb->mbs.add(mb));
		return mbs;
	}

	public MenuBook getMenuBook(long id) {
		MenuBook mb = menuBookRepository.findOne(id);
		if (mb == null) throw new ResourceNotFoundException();
		return mb;
	}

	public MenuBook addMenuBook(MenuBook menuBook) {
		menuBook.setId(0);
		menuBookRepository.saveAndFlush(menuBook);
		menuSequencesRepository.saveAndFlush(new MenuSequences(menuBook.getId()+"_menu",1));
		menuSequencesRepository.saveAndFlush(new MenuSequences(menuBook.getId()+"_submenu",1));
		
		return menuBook;
	}

	public MenuBook updateMenuBook(long id, MenuBook menuBook) {
		menuBook.setId(id);
		menuBookRepository.saveAndFlush(menuBook);
		return menuBook;
	}

	public void deleteMenuBook(long id) {
		menuBookRepository.delete(id);
		menuSequencesRepository.delete(id+"_menu");
		menuSequencesRepository.delete(id+"_submenu");
	}

}