package com.qikegu.demo.controller;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
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
	
	// 注入service类
    @Resource
    private UserService userService;
    
    // 注入RedisTemplate
    @Resource
    private RedisTemplate<String, Object> redis;
	
    // 读取用户信息，测试缓存使用：除了首次读取，接下来都应该从缓存中读取
    @RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public User getUser(@PathVariable long id) throws Exception {
    	
        User user = this.userService.getUserById(id);
        
        return user;
    }
    
    // 修改用户信息，测试删除缓存
    @RequestMapping(value = "/{id}/change-nick", method = RequestMethod.POST, produces="application/json")
    public User changeNickname(@PathVariable long id) throws Exception{
        
        String nick = "abc-" + Math.random();
        User user = this.userService.updateUserNickname(id, nick);
        
        return user;
    }
    
    // 使用RedisTemplate访问redis服务器
    @RequestMapping(value="/redis", method=RequestMethod.GET, produces="application/json")
    public String redis() throws Exception {
        
        // 设置键"project-name"，值"qikegu-springboot-redis-demo"
        redis.opsForValue().set("project-name", "qikegu-springboot-redis-demo");
        String value = (String) redis.opsForValue().get("project-name");
        
        return value;
    }
}