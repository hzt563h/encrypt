package com.hzt.encrypt.common;

/**
 * 通用返回对象
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;
    private String encryptKey;

    public CommonResult() {
    }

    public CommonResult(long code, String message, T data,String encryptKey) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.encryptKey=encryptKey;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }
}
