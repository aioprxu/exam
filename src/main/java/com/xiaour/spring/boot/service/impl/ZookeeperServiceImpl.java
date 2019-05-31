package com.xiaour.spring.boot.service.impl;

import com.xiaour.spring.boot.service.ZookeeperService;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ZookeeperServiceImpl implements ZookeeperService {
    @Override
    public String getConfig() throws Exception {
        String hostPort = "132.23.12.31:2181";
        List<String> zooChildren = new ArrayList<String>();
        ZooKeeper zk = new ZooKeeper(hostPort, 2000, null);
        if (zk != null) {
            try {
                String zpath = "/";
                zooChildren = zk.getChildren(zpath, false);
                System.out.println("Znodes of '/': ");
                for (String child : zooChildren) {
                    System.out.println(child);
                }
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String setConfig() {
        return null;
    }
}
