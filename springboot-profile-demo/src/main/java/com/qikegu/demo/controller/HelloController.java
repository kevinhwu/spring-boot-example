package com.qikegu.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@SuppressWarnings("unused")
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(HelloController.class);
	
	// 当前环境配置名称
    @Value("${profile.name}") //读取当前环境配置名称
    private String profileName;
	
	@RequestMapping(value="/hello", method = RequestMethod.GET, produces="application/json")
    public String hello() {
	   
		return "当前环境：" + profileName;
    }
}