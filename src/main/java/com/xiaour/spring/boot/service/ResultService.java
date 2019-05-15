package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Result;
import com.xiaour.spring.boot.response.ResultRsp;

import java.util.List;

public interface ResultService {
    List<ResultRsp> getResultByUser(int user);
    List<ResultRsp> getResultByExam(int exam);
}
