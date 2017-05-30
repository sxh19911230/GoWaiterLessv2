package com.gowaiterless.api.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class UserController {
	@RequestMapping("me")
	Principal getMe(Principal user) {
		return user;
	}

}
