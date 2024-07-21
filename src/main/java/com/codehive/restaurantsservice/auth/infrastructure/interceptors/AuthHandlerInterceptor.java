package com.codehive.restaurantsservice.auth.infrastructure.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;



public class AuthHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authUserUUID = request.getHeader("userUUID");
        request.setAttribute("authUserUUID", authUserUUID);

        System.out.println("AuthHandlerInterceptor");
        return true;

    }





}
