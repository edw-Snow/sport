package com.sport.common.result;


import lombok.Data;

/**
 *  成功时返回ResponseResult
 * @param <T>
 */
@Data
public class ResponseResult<T> {
    private Integer code; //1 成功
    private String msg; // 像前端返回提示信息
    private T data; //数据

    public static <T> ResponseResult<T> success() {
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setCode(1);
        return responseResult;
    }

    public static <T> ResponseResult<T> success(T object) {
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setCode(1);
        responseResult.setData(object);
        return responseResult;
    }

    public static <T> ResponseResult<T> success(String msg, T object){
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(1);
        responseResult.setMsg(msg);
        responseResult.setData(object);
        return responseResult;
    }

}
