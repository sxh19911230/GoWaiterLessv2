package com.gowaiterless.api.submenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class SubMenuController {
	@Autowired
	SubMenuService subMenuService;
	

}
