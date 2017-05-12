package com.gowaiterless.page;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GoWaiterLessController {
	
	@RequestMapping("/")
	public String mainPage() {
		return "index";
	}
	

}

