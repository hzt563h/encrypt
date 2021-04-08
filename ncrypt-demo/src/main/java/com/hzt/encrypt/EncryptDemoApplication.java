package com.hzt.encrypt;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 加解密启动类
 * @author hzt
 */
@SpringBootApplication
@MapperScan("com.hzt.encrypt.mapper")
public class EncryptDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncryptDemoApplication.class, args);
    }

}
