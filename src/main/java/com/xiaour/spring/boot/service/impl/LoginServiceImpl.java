package com.xiaour.spring.boot.service.impl;

import com.xiaour.spring.boot.mapper.UserInfoMapper;
import com.xiaour.spring.boot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean login(String name, String password) {
        String pwd = userInfoMapper.getPassword(name);
        if(password.equals(pwd)){
            return true;
        }
        return false;
    }
}
