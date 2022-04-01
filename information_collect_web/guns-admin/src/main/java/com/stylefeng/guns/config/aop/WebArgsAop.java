package com.stylefeng.guns.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Field;

/**
 * @Author gjx
 * @email 13450753745@163.com
 * @description 对请求参数的特殊字符处理
 * @Date 2019/12/23
 */
@Configuration
@Order(-1)
@Aspect
public class WebArgsAop {

    @Around("@annotation(TransformAnnotation)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Exception {
        Object proceed = null;
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        int count = 0;
        try{
            for (Object argItem : obj) {
                if (argItem instanceof String) {
                    String temp = (String) argItem;
                    temp = temp.replace("& #40;","（").replace("& #41;","）");
                    argItem = temp;
                    obj[count] = argItem;
                }else{
                    if(argItem.getClass().toString().contains("com.stylefeng.guns.modular.system.model")){
                        Field[] fields = argItem.getClass().getDeclaredFields();
                        for (int i=0;i<fields.length;i++){
                            Field f = fields[i];
                            f.setAccessible(true); // 设置些属性是可以访问的
                            Object val = f.get(argItem);// 得到此属性的值
                            String type = f.getType().toString();// 得到此属性的类型
                            if(type.endsWith("String"))
                            {
                                if(val!=null){
                                    f.set(argItem,((String)val).replace("& #40;","（").replace("& #41;","）")); // 给属性设值
                                }
                            }
                        }
                        obj[count] = argItem;
                    }
                }
                count++;
            }
            proceed = joinPoint.proceed(obj);
        } catch (Throwable throwable) {
        }

        return proceed;
    }

}
