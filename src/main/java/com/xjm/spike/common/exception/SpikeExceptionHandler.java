package com.xjm.spike.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjm.spike.result.CodeMsg;
import com.xjm.spike.result.Result;


@ControllerAdvice
@ResponseBody
public class SpikeExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		if(e instanceof SpikeException) {
			SpikeException ex = (SpikeException)e;
			return Result.error(ex.getCm());
		}else{
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
}
