package com.lttltm.fans.onesearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lttltm.fans.onesearch.model.User;

@Controller
@RequestMapping("/api/*")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	public String register(@RequestBody User user) {
		
		return null;
	}
	

}
