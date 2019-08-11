package com.xjm.spike.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjm.spike.result.CodeMsg;
import com.xjm.spike.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //什么都不做的话，那就直接调用父类的方法
        //super.onAuthenticationSuccess(request, response, authentication);


        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(new Result(CodeMsg.LOGIN_SYCCESS)));
        //登录成功跳转页面
        //如果是要跳转到某个页面的，比如我们的那个whoim的则
        //new DefaultRedirectStrategy().sendRedirect(request, response, "/whoim");
    }
}
