package com.sport.wrapper;

import com.alibaba.fastjson.JSON;
import com.sport.result.Result;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * 出错时封装response返回信息
 */
public class ResponseWrapper extends HttpServletResponseWrapper {
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public void sendCustomErrorResponse(Result result) throws IOException {
        HttpServletResponse originalResponse = (HttpServletResponse) getResponse();
        originalResponse.setStatus(result.getCode());
        originalResponse.setContentType("application/json;charset=UTF-8");
        originalResponse.getWriter().write(JSON.toJSONString(result));
    }
}
