package com.qikegu.demo.repository;

import java.util.List;

import com.qikegu.demo.model.User;

public interface UserMapper {

	// 查询某个用户，对应xml映射文件元素的ID
    User selectByPrimaryKey(long id);
    
    // 列出用户，对应xml映射文件元素的ID
    List<User> selectUser();
}