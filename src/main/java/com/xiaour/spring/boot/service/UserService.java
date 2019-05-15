package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.User;

import java.util.List;

public interface UserService {
    boolean delUser(int userId);
    boolean updateUser(User user);
    List<User> queryUser();
    boolean addUser(User user);
}
