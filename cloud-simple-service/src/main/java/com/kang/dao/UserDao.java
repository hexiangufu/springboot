package com.kang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kang.module.User;

@Mapper
public interface UserDao {
	public List<User> queryAll();
}
