package com.gowaiterless.api.menuList.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowaiterless.api.menuList.Choice;
import com.gowaiterless.api.menuList.Menu;
import com.gowaiterless.api.menuList.MenuSequences;
import com.gowaiterless.api.menuList.Restaurant;
import com.gowaiterless.api.menuList.SubMenu;
import com.gowaiterless.api.menuList.SubMenuId;
import com.gowaiterless.api.menuList.repository.MenuSequencesRepository;
import com.gowaiterless.api.menuList.repository.RestaurantRepository;
import com.gowaiterless.api.menuList.repository.SubMenuRepository;
import com.gowaiterless.exception.BadInputException;
import com.gowaiterless.exception.ResourceNotFoundException;


@Service
@Transactional
public class SubMenuService {
	@Autowired
	SubMenuRepository subMenuRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	MenuSequencesRepository menuSequencesRepository;
	
	public List<SubMenu> getSubMenus(String restaurantId, long subMenuId) {
		return subMenuRepository.findByMenusMenuId(new SubMenuId(getRestaurant(restaurantId), subMenuId)).orElseThrow(()->new ResourceNotFoundException());
	}

	public SubMenu addSubMenu(String restaurantId, SubMenu s) {
		
		Restaurant r = getRestaurant(restaurantId);
		s.getSubMenuId().setRestaurant(r);
		validateSubMenu(s);
		MenuSequences next = menuSequencesRepository.getOne(restaurantId+"_submenu");
		s.getSubMenuId().setSubMenuNum(next.getCount());
		next.setCount(next.getCount()+1);
		menuSequencesRepository.saveAndFlush(next);
		subMenuRepository.saveAndFlush(s);
		return s;
	}
	public SubMenu updateSubMenu(String restaurantId, long subMenuId, SubMenu s) {
		
		getSubMenu(restaurantId, subMenuId);
		s.getSubMenuId().setSubMenuNum(subMenuId);
		s.getSubMenuId().setRestaurant(getRestaurant(restaurantId));
		validateSubMenu(s);
		subMenuRepository.saveAndFlush(s);
		return s;
	}
	public void deleteSubMenu(String restaurantId, long subMenuId) {
		getRestaurant(restaurantId);
		subMenuRepository.delete(getSubMenu(restaurantId, subMenuId));
	}
	public List<SubMenu> getSubMenus(String restaurantId) {
		getRestaurant(restaurantId);
		return subMenuRepository.findBySubMenuIdRestaurantId(restaurantId).orElseThrow(()->new ResourceNotFoundException());
	}
	
	private Restaurant getRestaurant(String restaurantId) {
		Restaurant r = restaurantRepository.findOne(restaurantId);
		if(r==null) throw new ResourceNotFoundException();
		return r;
	}
	
	public SubMenu getSubMenu(String restaurantId, long subMenuId) {
		SubMenu s = subMenuRepository.findOne(new SubMenuId(getRestaurant(restaurantId),subMenuId));
		if(s==null) throw new ResourceNotFoundException();
		return s;
	}
	
	private void validateSubMenu(SubMenu s) {
		if (s.getChoices() != null)
		  for (Choice c : s.getChoices())
		    if (subMenuRepository.findBySubMenuIdRestaurantIdAndChoicesChoiceCode(s.getSubMenuId().getRestaurant().getId(), c.getChoiceCode()) != null)
			  throw new BadInputException();
	}

}
