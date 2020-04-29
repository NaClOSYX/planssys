package com.naclo.config;

import com.naclo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserService myUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/*").permitAll();
        // 开启表单认证
        http.formLogin()
                // 地址写的是 映射的路径
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/", true);
        //注销，跳转回首页
        http.logout().logoutSuccessUrl("/");
        //记住我
        http.rememberMe();
        //关闭csrf
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //通过自定义服务的方式来读取数据库中的数据，使用BCrypt加密方法
        auth.userDetailsService(myUserService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
