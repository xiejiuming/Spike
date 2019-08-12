package com.xjm.spike.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	private static Logger loggger = LoggerFactory.getLogger(LoginController.class);
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

    /**
     * 查看当前登录的用户信息
     * @return
     */
    @RequestMapping("/whoim")
    @ResponseBody
    public Object whoIm(){
    	loggger.info("");
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    
//    @RequestMapping("/login/from")
//    @ResponseBody
//    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
//    	log.info(loginVo.toString());
//    	//登录
////    	userService.login(response, loginVo);
//    	return Result.success(true);
//    }
}
