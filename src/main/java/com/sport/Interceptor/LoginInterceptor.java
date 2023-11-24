package com.sport.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sport.common.property.JwtProperty;
import com.sport.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtProperty jwtProperty;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(jwtProperty.getAdminTokenName());
//        Claims claims = JwtUtil.parseJwt(token,jwtProperty.getAdminSecretKey());
        if (!StringUtils.isEmpty(token)){

        }
        else{
            response.setContentType("application/json;charset=utf-8");
            JSONObject ret = new JSONObject();
            ret.put("hello","world");
            ret.put("right","away");
            response.getWriter().write(ret.toString());
            response.setStatus(500);
            return false;
        }
        return true;
    }

}
