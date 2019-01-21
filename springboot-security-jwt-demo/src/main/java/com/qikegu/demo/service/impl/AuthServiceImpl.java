package com.qikegu.demo.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.qikegu.demo.common.auth.AuthUser;
import com.qikegu.demo.common.auth.JwtUtil;
import com.qikegu.demo.model.User;
import com.qikegu.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User register(User userToAdd) {
    	// TODO: 保存user到数据库
        return null;
    }

    @Override
    public String login(String username, String password) {
    	// 认证用户，认证失败抛出异常，由JwtAuthError的commence类返回401
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        // 如果认证通过，返回jwt
    	final AuthUser userDetails = (AuthUser) userDetailsService.loadUserByUsername(username);
        final String token = jwtUtil.generateToken(userDetails.getUser());
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        String newToken = null;
        
        try {
        	newToken = jwtUtil.refreshToken(oldToken);
        } catch (Exception e) {
        	log.debug("异常详情", e);
        	log.info("无效token");
        }
		return newToken;
    }
}