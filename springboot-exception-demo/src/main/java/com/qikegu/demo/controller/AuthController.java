package com.qikegu.demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qikegu.demo.common.util.MiscUtil;
import com.qikegu.demo.common.util.Result;
import com.qikegu.demo.model.RegisterRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<Result> register(
    	@Valid @RequestBody RegisterRequest register
//    	, BindingResult bindingResult
    ) throws Exception {
    	
//		if(bindingResult.hasErrors()) {	
//			
//			Result res1 = MiscUtil.getValidateError(bindingResult);
//			return new ResponseEntity<Result>(res1, HttpStatus.UNPROCESSABLE_ENTITY);
//		}
    	
    	
		Result res = new Result(200, "ok");
        return ResponseEntity.ok(res);
    }
}