package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.User;

import java.util.List;


public interface UserInfoMapper {

    User selectByPrimaryKey(int id);

    String getPassword(String name);

    List<User> queryAllUser();

    boolean updateUser(User user);

    boolean delUser(int id);

    boolean insertUser(User user);
}