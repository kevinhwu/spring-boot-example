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
	    
		Result res = new Result(200, "ok");
		
		if(bad) {
	    	res.setStatus(400);
	    	res.setMessage("Bad request");
	        return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);
		}
        
		res.putData("words", "Hello world!");
		
		return ResponseEntity.ok(res);
    }
}