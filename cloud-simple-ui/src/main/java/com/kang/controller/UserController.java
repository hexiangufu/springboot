package com.kang.controller;

import com.kang.config.shiro.CaptchaUsernamePasswordToken;
import com.kang.entity.User;
import com.kang.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users")
	public ResponseEntity<List<User>> readUserInfo(){
		List<User> userList = userService.searchAll();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}

	//跳转到登录表单页面
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login() {
		return "login";
	}

	//跳转到主页
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "index";
	}

	/**
	 * ajax登录请求
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("/submitLogin")
	@ResponseBody
	public Map<String,Object> submitLogin(String username, String password,Model model) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		try {

			CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(username, password.toCharArray());
			SecurityUtils.getSubject().login(token);
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功");

		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		return resultMap;
	}

	@GetMapping("/logout")
	@ResponseBody
	public Map<String,Object> logout(){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			SecurityUtils.getSubject().logout();
		}catch (Exception e){
			e.printStackTrace();
		}
		return resultMap;
	}
}
