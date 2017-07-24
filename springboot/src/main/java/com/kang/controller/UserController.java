package com.kang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kang.module.User;
import com.kang.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	String home(Model model){
		List<User> userList = userService.queryAll();
		model.addAttribute("users", userList);
		return "user";
	}
}
