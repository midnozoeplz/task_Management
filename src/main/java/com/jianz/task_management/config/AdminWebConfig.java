package com.jianz.task_management.config;

import com.jianz.task_management.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jianz
 * @version 1.0
 * @Description
 * @Email jianz8153.gmail.com
 * @Date 2021/11/26 0:01
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")  //所有请求都被拦截包括静态资源
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/registration","/main","/main.html","login.html"); // 放行的资源
    }
}
