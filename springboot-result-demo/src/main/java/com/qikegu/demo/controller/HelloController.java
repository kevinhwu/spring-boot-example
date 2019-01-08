package com.qikegu.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qikegu.demo.common.util.Result;

@RestController
public class HelloController {
	
	@RequestMapping(value="/hello", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Result> hello(@RequestParam(value="bad", required=false, defaultValue="false") boolean bad) {
	    
		// 结果封装类对象
		Result res = new Result(200, "ok");
		
		if(bad) {
	    	res.setStatus(400);
	    	res.setMessage("Bad request");
	    	
	    	// ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
	        return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);
		}
        
		// 把结果数据放进封装类
		res.putData("words", "Hello world!");
		
		// ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回200
		return ResponseEntity.ok(res);
    }
}