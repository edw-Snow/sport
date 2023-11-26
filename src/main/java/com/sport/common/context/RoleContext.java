package com.sport.common.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程装入管理员权限，当用切点AdminRule时取出校验
 */
public class RoleContext {
    public static ThreadLocal<Map<Integer,String>> RoleContext = new ThreadLocal<>();

    public static void setRoleContext(Integer id,String Role){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(id,Role);
        RoleContext.set(map);
    }

    public static Map<Integer,String > getRoleContext(){
        return RoleContext.get();
    }

    public static void remove(){
        RoleContext.remove();
    }

}
