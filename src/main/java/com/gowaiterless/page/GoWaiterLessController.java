package com.gowaiterless.page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoWaiterLessController {
	
	@RequestMapping("/")
	public String mainPage() {
		
		return "index";
	}
	

}

