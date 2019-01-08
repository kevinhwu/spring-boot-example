package com.qikegu.demo.controller;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qikegu.demo.model.User;
import com.qikegu.demo.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
	
	// 注入mapper类
    @Resource
    private UserService userService;
	
    @RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public User getUser(@PathVariable long id) throws Exception {
    	
        User user = this.userService.getUserById(id);
        
        return user;
    }

}