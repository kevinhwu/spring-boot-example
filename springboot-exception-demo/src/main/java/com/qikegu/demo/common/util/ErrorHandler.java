package com.qikegu.demo.common.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice //表明这是控制器的异常处理类
public class ErrorHandler {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ErrorHandler.class);
	
	/**
	 * 输入参数校验异常
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Result> NotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) throws Exception {
		
		log.debug("异常详情", e);
		BindingResult bindingResult = e.getBindingResult();
		
		//rfc4918 - 11.2. 422: Unprocessable Entity			 
        Result res = MiscUtil.getValidateError(bindingResult);
        return new ResponseEntity<Result>(res, HttpStatus.UNPROCESSABLE_ENTITY);
    }
	
	/**
	 * 404异常处理
	 */
	@ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity<Result> NoHandlerFoundExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
		
		log.debug("异常详情", e);
				
		Result res = new Result(404, "页面不存在");
        return new ResponseEntity<Result>(res, HttpStatus.NOT_FOUND);
    }
	
	/**
	 *  默认异常处理，前面未处理
	 */
	@ExceptionHandler(value = Throwable.class)
    public ResponseEntity<Result> defaultHandler(HttpServletRequest req, Exception e) throws Exception {
		        
        Result res = new Result(500, "服务器内部错误");
        log.debug("异常详情", e);
        
        return new ResponseEntity<Result>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}