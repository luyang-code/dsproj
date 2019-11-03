package com.maple.MapleMall.Intercepto;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String adminname = (String)(request.getSession().getAttribute("adminname"));
        if(!adminname.equals("")){
            return true;
        }
        return false;
    }
}
