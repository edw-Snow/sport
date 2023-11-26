package com.sport.common.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 将管理员或者用户的id和role存入线程
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
