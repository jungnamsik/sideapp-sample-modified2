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

    private static String KEY  ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String requestURI = request.getRequestURI();
        switch (requestURI.toString()) {
            case "/app1": KEY = "d9H3ZMJlzBurlcskYyk3bLPPe7BFnCyS"; break ;
            case "/app2": KEY = "I8S6M8r75uFLLoxucQZn8AkUCNzqb8bc"; break ;
            case "/app3": KEY = "9BAxAnqnsFnkPyxeV72qewJuRaHB0B0W"; break ;
        }

        // System.out.println(">>>>["+ KEY+"]["+requestURI+"]["+ contextPath+"]");

        Map<String, Object> map = JwtUtils.parseJwsOnAuthorizationHeader(KEY, request.getHeader("Authorization"));

        request.setAttribute("sideAppParam", map);
        System.out.println(">>>>["+ map +"]");

        return true;
    }



}
