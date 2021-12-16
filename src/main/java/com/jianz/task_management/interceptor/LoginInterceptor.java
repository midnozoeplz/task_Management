package com.jianz.task_management.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jianz
 * @version 1.0
 * @Description 登录检查
 * 1.配置好拦截器要拦截哪些请求
 * @Email jianz8153.gmail.com
 * @Date 2021/11/25 23:58
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
   /**
    * @author Jianz
    * @version 1.0
    * @Description  目标方法执行之前
    * @Return
    * @Date 2021/11/25 23:59
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径为{}",requestURI);
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return true;
        }else {
            //session.setAttribute("msg","未登录");
            request.setAttribute("msg","未登录");
            //response.sendRedirect("/");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
