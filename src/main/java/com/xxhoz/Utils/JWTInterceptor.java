package com.xxhoz.Utils;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(JWTUtil.verify(token)){
            return true;
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(ResJsonUtils.Tojson(5,"认证失败",null));
        return false;
    }

}
