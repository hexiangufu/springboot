package com.kang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kang.entity.User;

@Mapper
public interface UserDao {
	public List<User> queryAll();
}
