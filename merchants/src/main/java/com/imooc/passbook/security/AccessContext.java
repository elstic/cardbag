package com.imooc.passbook.security;

/*
    用ThreadLocal 去单独存储每一个线程所携带的 Token 信息
 */
public class AccessContext {
    private static final ThreadLocal<String>  token = new ThreadLocal <>();

    public static String getToken(){
        return token.get();   // 返回token 所保存的信息
    }

    public static void setToken(String  tokenStr){
        token.set(tokenStr);
    }

    public static void clearAccessKey(){
        token.remove();     // 线程执行完之后本就会删除信息，但是安全起见还是清楚除一下
    }
}
