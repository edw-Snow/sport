package com.sport.common.result;


import lombok.Data;

/**
 *  成功时返回ResponseResult
 * @param <T>
 */
@Data
public class ResponseResult<T> {
    private Integer code; // 返回状态码 200 403 401等
    private String msg; // 向前端返回提示信息
    private T data; //数据

    public static <T> ResponseResult<T> success() {
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setCode(200);
        return responseResult;
    }

    public static <T> ResponseResult<T> success(T object) {
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setCode(200);
        responseResult.setData(object);
        return responseResult;
    }

    public static <T> ResponseResult<T> success(String msg, T object){
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setCode(200);
        responseResult.setMsg(msg);
        responseResult.setData(object);
        return responseResult;
    }

    public static <T> ResponseResult<T> error(String msg,int code){
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
