package com.qikegu.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.LoggerFactory;

public class RegisterRequest {
	
	@SuppressWarnings("unused")
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(RegisterRequest.class);
	
	@NotNull(message="手机号必须填")
	@Pattern(regexp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$", message="账号请输入11位手机号") // 手机号
	private String mobile;
	
	@NotNull(message="昵称必须填")
	@Size(min=1, max=20, message="昵称1~20个字")
	private String nickname;
	
    @NotNull(message="密码必须填")
    @Size(min=6, max=16, message="密码6~16位")
	private String password;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    	
}