package com.sport.common.context;

public class IDThreadContext {
        public static ThreadLocal<Integer> idThreadContext = new ThreadLocal<>();

        public static void setIdThreadContext(Integer id){
            idThreadContext.set(id);
        }

        public static Integer getIdThreadContext(Integer id){
            return idThreadContext.get();
        }

        public static void removeIdThreadContext(){
            idThreadContext.remove();
        }
}
