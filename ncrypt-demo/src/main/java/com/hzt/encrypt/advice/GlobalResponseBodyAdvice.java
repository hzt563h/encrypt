package com.hzt.encrypt.advice;

import com.alibaba.fastjson.JSON;
import com.hzt.encrypt.annotation.Encrypt;
import com.hzt.encrypt.common.CommonResult;
import com.hzt.encrypt.common.RSAKey;
import com.hzt.encrypt.util.AES;
import com.hzt.encrypt.util.RSA;
import com.hzt.encrypt.util.SecureRandomUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName GlobalResponseBodyAdvice.java
 */

@ControllerAdvice//(basePackages = "com.hzt.encrypt.controller")可以设置作用域，不设置默认全局生效
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return methodParameter.getMethodAnnotation(Encrypt.class) != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //随机生成AES密钥
        String aesKey = SecureRandomUtil.getRandom(16);
        //AES加密数据
        String data = AES.encryptToBase64(JSON.toJSONString(o), aesKey);
        String encryptkey="";
        try {
            encryptkey = RSA.encrypt(aesKey, RSAKey.serverPublicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        CommonResult result = new CommonResult(200, "成功", data, encryptkey);
        return result;
    }
}
