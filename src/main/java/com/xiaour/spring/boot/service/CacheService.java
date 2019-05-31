package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Cache;
import com.xiaour.spring.boot.response.GetCacheRsp;

public interface CacheService {

    boolean addCache(Cache cache);

    String getCache(int exam, int user);

}
