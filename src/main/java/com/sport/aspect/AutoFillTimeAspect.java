package com.sport.aspect;

import com.sport.annotation.AutoFIllTime;
import com.sport.common.constant.AutoFIllTimeConstant;
import com.sport.common.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 切面用于Mapper，自动更新UPDATE_TIME，CREATE_TIME
 */
@Aspect
@Component
@Slf4j
public class AutoFillTimeAspect {

    @Pointcut("@annotation(com.sport.annotation.AutoFIllTime)")
    public void autoFillPointCut() {
    }

    public void autoFillTime(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); //获取方法签名对象
        AutoFIllTime autoFIllTime = signature.getMethod().getAnnotation(AutoFIllTime.class); //获取注解对象
        OperationType value = autoFIllTime.value(); //获取数据库操作类型

        //获取实体类
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity =args[0];
        LocalDateTime now = LocalDateTime.now();

        //插入操作
        if(value==OperationType.INSERT){
            try {
                //获取方法对象
                Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFIllTimeConstant.SET_CREATE_TIME, LocalDateTime.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFIllTimeConstant.SET_UPDATE_TIME, LocalDateTime.class);
                //执行方法对象
                setCreateTime.invoke(entity,now);
                setUpdateTime.invoke(entity,now);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //更新操作
        } else if (value==OperationType.UPDATE) {
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFIllTimeConstant.SET_UPDATE_TIME, LocalDateTime.class);
                setUpdateTime.invoke(entity,now);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
