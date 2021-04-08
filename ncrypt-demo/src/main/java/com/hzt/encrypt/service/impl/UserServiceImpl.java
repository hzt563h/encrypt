package com.hzt.encrypt.service.impl;

import com.hzt.encrypt.entity.User;
import com.hzt.encrypt.mapper.UserMapper;
import com.hzt.encrypt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @createTime 2021年04月07日 15:24:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserListAll() {
        return userMapper.selectList(null);
    }
}
