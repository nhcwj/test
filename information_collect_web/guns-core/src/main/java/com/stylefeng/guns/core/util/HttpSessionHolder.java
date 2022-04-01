package com.stylefeng.guns.core.util;

import javax.servlet.http.HttpSession;

/**
 * 非Controller中获取当前session的工具类
 *
 * @author fengshuonan
 * @date 2016年11月28日 上午10:24:31
 */
public class HttpSessionHolder {

    private static ThreadLocal<HttpSession> tl = new ThreadLocal<HttpSession>();

    private static ThreadLocal<Integer> test = new ThreadLocal<Integer>(){
        @Override
        public Integer initialValue(){
            return new Integer(0);
        }
    };

    public static void put(HttpSession s) {

        tl.set(s);
    }

    public static HttpSession get() {
        System.out.println("线程ID:"+Thread.currentThread().getId());
        return tl.get();
    }

    public static void remove() {
        tl.remove();
    }

    public static void addTest(){
        test.set(test.get()+1);
    }
    public static Integer getTest(){
        return test.get();
    }
}
