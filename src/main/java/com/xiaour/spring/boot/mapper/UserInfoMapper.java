package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.UserInfo;
import org.springframework.stereotype.Component;

//@Component
public interface UserInfoMapper {

    UserInfo selectByPrimaryKey(Integer id);

}