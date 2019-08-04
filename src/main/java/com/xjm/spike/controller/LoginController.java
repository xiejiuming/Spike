package com.xjm.spike.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.xjm.spike.vo.LoginVo;
import com.xjm.spike.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
//
//	@Autowired
//	MiaoshaUserService userService;
//
//	@Autowired
//	RedisService redisService;
	
    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(){
        return "login-error";
    }
    
    @RequestMapping("/login/from")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
    	log.info(loginVo.toString());
    	//登录
//    	userService.login(response, loginVo);
    	return Result.success(true);
    }
}
