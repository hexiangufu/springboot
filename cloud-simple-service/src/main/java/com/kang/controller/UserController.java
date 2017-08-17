package com.kang.controller;


import com.kang.entity.User;
import com.kang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kk
 * @since 2017-08-10
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private IUserService userService;

	@GetMapping("/selectByMap")
	public List<User> selectByMap(@RequestParam Map<String,Object> paramMap){
        return userService.selectByMap(paramMap);
    }

    @PutMapping("/updateById")
    public boolean updateById(@RequestBody User user){
	    return userService.updateById(user);
    }
}
