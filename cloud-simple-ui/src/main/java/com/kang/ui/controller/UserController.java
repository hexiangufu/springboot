package com.kang.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kang.ui.model.User;
import com.kang.ui.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@Value("${spring.datasource.initial-size}") String size;
	
	@RequestMapping(value="/users")
	public ResponseEntity<List<User>> readUserInfo(){
		List<User> userList = userService.searchAll();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}

	@RequestMapping("/size")
	public String size(){
		return size;
	}
}
