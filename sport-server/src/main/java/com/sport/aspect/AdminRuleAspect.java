package com.sport.aspect;

import com.sport.constant.HttpStatusConstant;
import com.sport.constant.MessageConstant;
import com.sport.context.RoleContext;
import com.sport.result.Result;
import com.sport.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class AdminRuleAspect {

    @Pointcut("@annotation(com.sport.annotation.AdminRule)")
    public void AdminRulePointCut() {
    }

    @Around("AdminRulePointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("=========>管理员权限校验");
        Map<Integer, String> roleContext = RoleContext.getRoleContext();
        ArrayList<Integer> list = new ArrayList<>(roleContext.keySet());
        String role = roleContext.get(list.get(0));
        if (!"admin".equals(role)) {
            try {
                HttpServletResponse response = (HttpServletResponse) joinPoint.getArgs()[0];
                log.info("==========>管理权限校验失败");
                Result<Object> result = new Result<>();
                result.setCode(HttpStatusConstant.UNAUTHORIZED);
                result.setMsg(MessageConstant.JWT_VALIDATION_ERROR);
                ResponseWrapper responseWrapper = new ResponseWrapper(response);
                responseWrapper.sendCustomErrorResponse(result);
            } catch (IOException e) {
                log.error("异常信息：{}", e.getMessage());
            }
        }
        return joinPoint.proceed();
    }
}
