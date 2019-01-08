package com.qikegu.demo.repository;

import com.qikegu.demo.model.User;

public interface UserMapper {

	// 对应xml映射文件元素的ID
    User selectByPrimaryKey(long id);

}