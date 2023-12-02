package com.sport.handle;

import com.sport.common.constant.HttpStatusConstant;
import com.sport.common.constant.MessageConstant;
import com.sport.common.exception.CustomException;
import com.sport.common.result.Result;
import com.sport.common.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *  全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public void exceptionHandler(Exception ex, HttpServletResponse response) {
        log.error("异常信息：{}", ex.getMessage());
        try {
            Result<String> result = new Result<>();
            result.setMsg(MessageConstant.SERVER_ERROR);
            result.setCode(HttpStatusConstant.INTERNAL_SERVER_ERROR);
            ResponseWrapper responseWrapper = new ResponseWrapper(response);
            responseWrapper.sendCustomErrorResponse(result);
        } catch (IOException e) {
            log.error("异常信息：{}",e.getMessage());
        }
    }
    @ExceptionHandler
    public void exceptionHandler(CustomException ex, HttpServletResponse response){
        log.error("异常信息{}",ex.getMessage());
        try {
            Result<String> result = new Result<>();
            result.setMsg(ex.getMessage());
            result.setCode(HttpStatusConstant.INTERNAL_SERVER_ERROR);
            ResponseWrapper responseWrapper = new ResponseWrapper(response);
            responseWrapper.sendCustomErrorResponse(result);
        } catch (IOException e) {
            log.error("异常信息：{}",e.getMessage());
        }
    }
    @ExceptionHandler
    public void exceptionHandler(SQLException ex, HttpServletResponse response){
        log.error("异常信息{}",ex.getMessage());
        Result<String> result = new Result<>();
        try {
            result.setMsg(MessageConstant.SQL_EXCEPTION);
            result.setCode(HttpStatusConstant.INTERNAL_SERVER_ERROR);
            ResponseWrapper responseWrapper = new ResponseWrapper(response);
            responseWrapper.sendCustomErrorResponse(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}