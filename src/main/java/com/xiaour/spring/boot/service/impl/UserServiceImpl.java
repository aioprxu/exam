package com.xiaour.spring.boot.service.impl;

import com.xiaour.spring.boot.entity.User;
import com.xiaour.spring.boot.mapper.UserInfoMapper;
import com.xiaour.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean delUser(int userId) {
        return userInfoMapper.delUser(userId);
    }

    @Override
    public boolean updateUser(User user) {
        return userInfoMapper.updateUser(user);
    }

    @Override
    public List<User> queryUser() {
        return userInfoMapper.queryAllUser();
    }

    @Override
    public boolean addUser(User user) {
        return userInfoMapper.insertUser(user);
    }
}
