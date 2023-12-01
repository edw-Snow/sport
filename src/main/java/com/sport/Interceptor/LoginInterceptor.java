package com.sport.Interceptor;

import com.sport.common.constant.HttpStatusConstant;
import com.sport.common.constant.JwtClaimConstant;
import com.sport.common.constant.MessageConstant;
import com.sport.common.context.RoleContext;
import com.sport.common.property.JwtProperty;
import com.sport.common.result.Result;
import com.sport.common.util.JwtUtil;
import com.sport.common.wrapper.ResponseWrapper;
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
        String adminToken = request.getHeader(jwtProperty.getAdminTokenName());
        String userToken = request.getHeader(jwtProperty.getUerTokenName());
        ResponseWrapper responseWrapper = new ResponseWrapper(response);

        // 没有管理员和用户的token，即是没有登录
        if (StringUtils.isEmpty(adminToken) && StringUtils.isEmpty(userToken)) {
            Result<Object> result = new Result<>();
            result.setMsg(MessageConstant.NOT_LOGIN);
            result.setCode(HttpStatusConstant.UNAUTHORIZED);
            responseWrapper.sendCustomErrorResponse(result);
            return false;
        }

        //解析管理员或用户token,并存入线程
        try {
            if (userToken != null && userToken.length() > 0) {
                Claims claims = JwtUtil.parseJwt(userToken, jwtProperty.getUserSecretKey());
                Integer id = Integer.valueOf(claims.get(JwtClaimConstant.USER_ID).toString());
                RoleContext.setRoleContext(id,"user");
                return true;
            }
            Claims claims = JwtUtil.parseJwt(adminToken, jwtProperty.getAdminSecretKey());
            Integer userID = Integer.valueOf(claims.get(JwtClaimConstant.ADMIN_ID).toString());
            RoleContext.setRoleContext(userID,"admin");
            return true;
        //解析token报错，返回前端状态码401
        } catch (Exception e) {
            log.info(e.getMessage());
            Result<Object> result = new Result<>();
            result.setMsg(MessageConstant.JWT_VALIDATION_ERROR);
            result.setCode(HttpStatusConstant.UNAUTHORIZED);
            responseWrapper.sendCustomErrorResponse(result);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RoleContext.remove();
    }
}
