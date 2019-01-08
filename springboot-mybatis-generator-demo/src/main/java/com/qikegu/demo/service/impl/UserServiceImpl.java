package com.qikegu.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.qikegu.demo.model.User;
import com.qikegu.demo.repository.UserMapper;
import com.qikegu.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	//注入mybatis数据库查询类
    @Resource
    private UserMapper userMapper;
    
    @Override
    public User getUserById(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
    
//	@Override
//	public List<User> listUser(int page, int pageSize) {
//        List<User> result = null;
//        try {
//            PageHelper.startPage(page, pageSize); //每页的大小为pageSize，查询第page页的结果
//            PageHelper.orderBy("id ASC "); //进行分页结果的排序
//        	result = userMapper.selectUser();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//		return result;
//	}
}