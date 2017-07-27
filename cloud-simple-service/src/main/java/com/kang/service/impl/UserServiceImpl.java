package com.kang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kang.dao.UserDao;
import com.kang.module.User;
import com.kang.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

}
