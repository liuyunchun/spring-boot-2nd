package com.yunchun.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component("com.yunchun.interceptor.Interceptor")
public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        HttpSession session = request.getSession();
        boolean returnBoolean=true;
        if (session.getAttribute("userId") == null) {
            response.sendRedirect("/login");
            returnBoolean=false;
        }
        System.out.println("處理前");
        return returnBoolean;
//        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("處理後");
        super.postHandle(request, response, handler, modelAndView);
    }
}
