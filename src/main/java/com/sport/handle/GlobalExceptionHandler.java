package com.sport.handle;

import com.sport.common.constant.HttpStatusConstant;
import com.sport.common.constant.MessageConstant;
import com.sport.common.wrapper.ErrorResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public void exceptionHandler(Exception ex,HttpServletResponse response) {
        log.error("异常信息：{}", ex.getMessage());
        try {
            ErrorResponseWrapper errorResponseWrapper = new ErrorResponseWrapper(response);
            errorResponseWrapper.sendCustomErrorResponse(MessageConstant.SERVER_ERROR, HttpStatusConstant.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            log.error("异常信息：{}",e.getMessage());
        }
    }
}
