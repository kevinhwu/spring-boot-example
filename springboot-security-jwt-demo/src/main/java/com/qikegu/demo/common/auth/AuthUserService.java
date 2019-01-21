package com.qikegu.demo.common.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.qikegu.demo.model.User;

@Service
public class AuthUserService implements UserDetailsService {

	// 加载用户信息
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 此处应从数据库加载用户信息，为简便起见，直接创建一个用户
		// password的值：$2a$10$EmsokMb6Vkav7m61kY0PtO.ZCLe0h.uJqVAZW7YYBpSUxd/DMkZuG，
		// 是明文123456使用BCryptPasswordEncoder加密的值
		User user = new User(1l, "abc1", username, "$2a$10$EmsokMb6Vkav7m61kY0PtO.ZCLe0h.uJqVAZW7YYBpSUxd/DMkZuG", "user");
		AuthUser authUser = new AuthUser(user);
		
		return (UserDetails) authUser;
	}
}