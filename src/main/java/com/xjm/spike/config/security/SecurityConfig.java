package com.xjm.spike.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthenticationProvider provider;  //注入我们自己的AuthenticationProvider

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailHander;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin().loginPage("/login").loginProcessingUrl("/login/form").failureUrl("/login-error").permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
            .successHandler(myAuthenticationSuccessHandler)
            .failureHandler(myAuthenticationFailHander)
            .and()
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .csrf().disable();

    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/bootstrap/**","/jquery-validation/**","/js/**","/jquery-validation/**","/layer/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(provider);


//        auth
//            .inMemoryAuthentication()
//            .passwordEncoder(new MyPasswordEncoder());//在此处应用自定义PasswordEncoder
//            .withUser("15900527865")
//            .password("123456")
//            .roles("admin");
    }


}
