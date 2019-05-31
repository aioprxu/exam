package com.xiaour.spring.boot.service;

public interface ZookeeperService {

    String getConfig() throws Exception;

    String setConfig();

}
