package com.qikegu.demo.service;

import com.qikegu.demo.model.User;

public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}