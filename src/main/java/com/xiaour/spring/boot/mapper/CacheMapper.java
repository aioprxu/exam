package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.Cache;
import org.apache.ibatis.annotations.Param;


public interface CacheMapper {

    boolean insertCache(Cache cache);

    boolean delCache(@Param("exam")int exam, @Param("user")int user);

    Cache getCache(@Param("exam")int exam, @Param("user")int user);

}
