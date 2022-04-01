package com.stylefeng.guns.config.aop;

import java.lang.annotation.*;

/**
 * 代码创建: gjx <br/>
 * 创建日期: 2019年12月25日 <br/>
 * 功能描述: 定义字符串转义注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TransformAnnotation {
}
