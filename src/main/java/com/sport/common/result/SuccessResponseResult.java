package com.sport.common.result;


import lombok.Data;

@Data
public class SuccessResponseResult<T> {
    private Integer code; //1 成功
    private String msg; // 像前端返回提示信息
    private T data; //数据

    public static <T> SuccessResponseResult<T> success() {
        SuccessResponseResult<T> successResponseResult = new SuccessResponseResult<T>();
        successResponseResult.setCode(1);
        return successResponseResult;
    }

    public static <T> SuccessResponseResult<T> success(T object) {
        SuccessResponseResult<T> successResponseResult = new SuccessResponseResult<T>();
        successResponseResult.setCode(1);
        successResponseResult.setData(object);
        return successResponseResult;
    }

    public static <T> SuccessResponseResult<T> success(String msg, T object){
        SuccessResponseResult<T> successResponseResult = new SuccessResponseResult<>();
        successResponseResult.setCode(1);
        successResponseResult.setMsg(msg);
        successResponseResult.setData(object);
        return successResponseResult;
    }

}
