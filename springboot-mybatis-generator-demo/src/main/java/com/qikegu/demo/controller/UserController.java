package com.qikegu.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    
//    @RequestMapping(value="", method = RequestMethod.GET, produces="application/json")
//    public PageInfo<User> listUser(
//    		@RequestParam(value="page", required=false, defaultValue="1") int page,
//    		@RequestParam(value="page-size", required=false, defaultValue="5") int pageSize){
//    	
//
//        List<User> result = userService.listUser(page, pageSize);
//        // PageInfo包装结果，返回更多分页相关信息
//        PageInfo<User> pi = new PageInfo<User>(result);
//        
//        return pi;
//    }

}