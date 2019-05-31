package com.xiaour.spring.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.entity.Cache;
import com.xiaour.spring.boot.mapper.CacheMapper;
import com.xiaour.spring.boot.response.GetCacheRsp;
import com.xiaour.spring.boot.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheMapper cacheMapper;

    @Override
    public boolean addCache(Cache cache) {
        cacheMapper.delCache(cache.getExamId(), cache.getUserId());
        return cacheMapper.insertCache(cache);
    }

    @Override
    public String getCache(int exam, int user) {
        return cacheMapper.getCache(exam, user).getAnswer();
    }
}
