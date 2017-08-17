package com.kang.service;

import com.kang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

	public List<User> selectByMap(Map<String, Object> paramMap){
		User[] userArray= restTemplate.getForObject("http://"+SERVICE_NAME+"/user/selectByMap?nickname={nickname}&pswd={pswd}", User[].class,paramMap);
		return Arrays.asList(userArray);
	}

	public void updateById(User user){
		restTemplate.put("http://"+SERVICE_NAME+"/user/updateById",user);
	}

}
