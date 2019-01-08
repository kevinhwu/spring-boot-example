package com.qikegu.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qikegu.demo.model.User;
import com.qikegu.demo.repository.UserMapper;
import com.qikegu.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    
    @Override
    public User getUserById(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}