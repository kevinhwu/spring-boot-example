package com.qikegu.demo.service;

import java.util.List;

import com.qikegu.demo.model.User;

public interface UserService {
	
    public User getUserById(long userId);
    
//    public List<User> listUser(int page, int pageSize);
}