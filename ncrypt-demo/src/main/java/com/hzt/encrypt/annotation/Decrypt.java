package com.hzt.encrypt.annotation;

import java.lang.annotation.*;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName Decrypt.java
 * @Description TODO 解密
 * @createTime 2021年01月08日 10:32:00
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Decrypt {
}
