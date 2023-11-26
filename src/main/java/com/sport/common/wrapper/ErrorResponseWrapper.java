package com.sport.common.wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * 出错时封装response返回信息
 */
public class ErrorResponseWrapper extends HttpServletResponseWrapper {
    public ErrorResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public void sendCustomErrorResponse(String message, int status) throws IOException {
        HttpServletResponse originalResponse = (HttpServletResponse) getResponse();
        originalResponse.setStatus(status);
        originalResponse.setContentType("application/json;charset=UTF-8");
        originalResponse.getWriter().write(message);
    }

}
