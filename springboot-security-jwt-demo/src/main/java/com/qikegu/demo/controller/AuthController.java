package com.qikegu.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qikegu.demo.common.util.MiscUtil;
import com.qikegu.demo.common.util.Result;
import com.qikegu.demo.model.LoginRequest;
import com.qikegu.demo.model.User;
import com.qikegu.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
    @Autowired
    private AuthService authService;
    
	/**
	 * login 
	 * @param authRequest
	 * @param bindingResult
	 * @return ResponseEntity<Result> 
	 */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<Result> login(@Valid @RequestBody LoginRequest authRequest, BindingResult bindingResult) throws AuthenticationException{
    	
		if(bindingResult.hasErrors()) {			
			Result res = MiscUtil.getValidateError(bindingResult);
			return new ResponseEntity<Result>(res, HttpStatus.UNPROCESSABLE_ENTITY);
		}
    	
        final String token = authService.login(authRequest.getAccount(), authRequest.getPassword());
        
        // Return the token
        Result res = new Result(200, "ok");
        res.putData("token", token);
        return ResponseEntity.ok(res);
    }
    
	/**
	 * refresh 
	 * @param request
	 * @return ResponseEntity<Result> 
	 */
    @RequestMapping(value = "/refresh", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Result> refresh(HttpServletRequest request, @RequestParam String token) throws AuthenticationException{
    	
    	Result res = new Result(200, "ok");
    	
    	String refreshedToken = authService.refresh(token);
        
        if(refreshedToken == null) {
        	res.setStatus(400);
        	res.setMessage("无效token");
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);
        } 
        
        
        res.putData("token", token);
        return ResponseEntity.ok(res);
    }
	
}