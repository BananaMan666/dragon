package com.dragon.banana.auth;

/**
 * @Author llx
 * @Description JwtUser threadLocal
 * @Date 4:32 下午 2021/10/26
 */
public class JwtUserThreadLocal {

    private static final ThreadLocal<JwtUser> JWT_USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void set(JwtUser jwtUser) {
        JWT_USER_THREAD_LOCAL.set(jwtUser);
    }

    public static JwtUser get() {
        return JWT_USER_THREAD_LOCAL.get();
    }

    public static void remove() {
        JWT_USER_THREAD_LOCAL.remove();
    }

}
