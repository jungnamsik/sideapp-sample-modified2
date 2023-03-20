package com.dooray.sideapp.controllers;

import com.auth0.jwt.interfaces.Claim;
import com.dooray.sideapp.util.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    // TODO: 사이드앱 설정에서 KEY 값을 생성해 수정합니다.
    // private static final String KEY = "secret_123456789_123456789_123456789_123456789_123456789_123456789";
    // private static final String KEY = "d9H3ZMJlzBurlcskYyk3bLPPe7BFnCyS.d9H3ZMJlzBurlcskYyk3bLPPe7BFnCyS.";
    private static final String KEY = "d9H3ZMJlzBurlcskYyk3bLPPe7BFnCyS";
    //7rWsRfdIXvfuaXnhdlNqDNjGmXNzIzsx
    //d9H3ZMJlzBurlcskYyk3bLPPe7BFnCyS


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Map<String, Object> map = JwtUtils.parseJwsOnAuthorizationHeader(KEY, request.getHeader("Authorization"));
        request.setAttribute("sideAppParam", map);

        return true;
    }
}
