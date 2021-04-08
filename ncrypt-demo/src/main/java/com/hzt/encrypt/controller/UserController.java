package com.hzt.encrypt.controller;

import com.hzt.encrypt.annotation.Encrypt;
import com.hzt.encrypt.entity.User;
import com.hzt.encrypt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName UserController.java
 * @createTime 2021年04月07日 15:27:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Encrypt
    @GetMapping("/getUserListAll")
    public List<User> getUserListAll(){
        List<User> userListAll = userService.getUserListAll();
        return userListAll;
    }
}
