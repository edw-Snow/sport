package com.sport.handle;

import com.sport.constant.HttpStatusConstant;
import com.sport.constant.MessageConstant;
import com.sport.exception.CustomException;
import com.sport.result.Result;
import com.sport.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public void handleException(Exception ex, HttpServletResponse response) {
        processException(response, MessageConstant.SERVER_ERROR, ex);
    }

    @ExceptionHandler()
    public void handleCustomException(CustomException ex, HttpServletResponse response) {
        processException(response, ex.getMessage(), ex);
    }

    @ExceptionHandler()
    public void handleSQLException(SQLException ex, HttpServletResponse response) {
        processException(response, MessageConstant.SQL_EXCEPTION, ex);
    }

    private void processException(HttpServletResponse response, String message, Exception ex) {
        log.error("异常信息：{}", ex.getMessage());
        try {
            ResponseWrapper responseWrapper = new ResponseWrapper(response);
            responseWrapper.sendCustomErrorResponse(Result.error(message, HttpStatusConstant.INTERNAL_SERVER_ERROR));
        } catch (IOException e) {
            log.error("处理异常时出现错误：{}", e.getMessage());
        }
    }
}