package com.hzt.encrypt.advice;

import com.alibaba.fastjson.JSON;
import com.hzt.encrypt.annotation.Decrypt;
import com.hzt.encrypt.common.CommonResult;
import com.hzt.encrypt.common.RSAKey;
import com.hzt.encrypt.util.AES;
import com.hzt.encrypt.util.RSA;
import org.apache.commons.io.IOUtils;


import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName RequestBodyAdvice.java
 */

@ControllerAdvice
public class GlobalRequestBodyAdvice implements RequestBodyAdvice {
    /** 此处如果返回false , 则不执行当前Advice的业务 */
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * @title 读取参数前执行
     * @description 在此做些编码 / 解密 / 封装参数为对象的操作
     *  */
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        Decrypt decrypt = methodParameter.getMethodAnnotation(Decrypt.class);
        if (decrypt !=null){
            return new MyHttpInputMessage(httpInputMessage);
        }
        return httpInputMessage;
    }

    /**
     * @title 读取参数后执行
     */
    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }

    /**
     * @title 无请求时的处理
     */

    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }
    class MyHttpInputMessage implements HttpInputMessage {
        HttpHeaders headers;
        InputStream body;

        public MyHttpInputMessage(HttpInputMessage httpInputMessage) throws IOException {
            this.headers = httpInputMessage.getHeaders();
            // 解密操作
            InputStream body = httpInputMessage.getBody();
            String bodyJson = IOUtils.toString(body, "UTF-8");
            CommonResult<String> commonResult = JSON.parseObject(bodyJson, CommonResult.class);
            String aesKey = null;
            try {
                aesKey = RSA.decrypt(commonResult.getEncryptKey(),
                        RSAKey.clientPrivateKey);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String data = AES.decryptFromBase64(commonResult.getData(),
                    aesKey);
            this.body=IOUtils.toInputStream(data, "UTF-8");
        }

        @Override
        public InputStream getBody() {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
    }

}
