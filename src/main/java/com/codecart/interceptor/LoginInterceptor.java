package com.codecart.interceptor;

import com.codecart.pojo.Result;
import com.codecart.util.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try{
            Map<String, Object> claims =  JWTUtils.parseToken(token);
            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }

    }
}
