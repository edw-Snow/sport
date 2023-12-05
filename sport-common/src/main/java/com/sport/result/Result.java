package com.sport.result;


import com.sport.constant.HttpStatusConstant;
import lombok.Data;

/**
 *  成功时返回ResponseResult
 * @param <T>
 */
@Data
public class Result<T> {
    private Integer code; // 返回状态码 200 403 401等
    private String msg; // 向前端返回提示信息
    private T data; //数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.setCode(HttpStatusConstant.SUCCESS);
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.setCode(HttpStatusConstant.SUCCESS);
        result.setData(object);
        return result;
    }

    public static <T> Result<T> success(String msg, T object){
        Result<T> result = new Result<T>();
        result.setCode(HttpStatusConstant.SUCCESS);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static <T> Result<T> error( String msg,int code){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
