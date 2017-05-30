package com.gowaiterless.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gowaiterless.api.User;

@RestController
@RequestMapping("user/")
public class UserController {
	@RequestMapping("me")
	User getMe(HttpServletRequest res) {
		User u = new User(res.getUserPrincipal().getName());
		return u;
	}

}
