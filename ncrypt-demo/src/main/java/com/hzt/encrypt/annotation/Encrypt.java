package com.hzt.encrypt.annotation;

import java.lang.annotation.*;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName Encrypt.java
 * @Description TODO 加密
 * @createTime 2021年01月08日 10:27:00
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Encrypt {
}
