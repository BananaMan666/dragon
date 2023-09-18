package com.dragon.banana.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liulongxiang
 * @Date 2023/9/17 16:30
 * @Description
 */
@Component
@RequiredArgsConstructor
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private final JwtTokenUtils jwtTokenUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        // OPTIONS请求放过
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        // 校验token是否为空
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isEmpty(jwtToken)) {
            response.getWriter().write("{\"success\": false, \"code\": 40001, \"message\":\"请登录后再访问\"}");
            return false;
        }
        // 校验token是否有效
        String token = jwtToken.replace("Bearer ", "");
        if (!JwtTokenUtils.validateToken(token)) {
            response.getWriter().write("{\"success\": false, \"code\": 40001, \"message\":\"您没有权限访问\"}");
            return false;
        }

//        JwtUserThreadLocal.set(jwtTokenUtils.getJwtUser(token));
        // token有效，通过
        return true;
    }
}
