package com.kang.ui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kang.ui.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
	@Autowired
	RestTemplate restTemplate;
	
	final String SERVICE_NAME="cloud-simple-service";
	
	//@HystrixCommand(fallbackMethod="fallbackSearchAll")
	public List<User> searchAll(){
		return restTemplate.getForObject("http://"+SERVICE_NAME+"/user", List.class);
	}
	
	private List<User> fallbackSearchAll(){
		System.out.println("HystrixCommand fallbackMethod handle!");
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setName("TestHytrix");
		userList.add(user);
		return userList;
	}
}
