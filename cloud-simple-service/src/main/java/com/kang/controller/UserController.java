package com.kang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kang.module.User;
import com.kang.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> queryAll(Model model){
		return userService.queryAll();
	}
}
