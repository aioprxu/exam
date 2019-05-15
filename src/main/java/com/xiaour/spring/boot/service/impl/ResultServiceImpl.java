package com.xiaour.spring.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.entity.Result;
import com.xiaour.spring.boot.mapper.ExamMapper;
import com.xiaour.spring.boot.mapper.ResultMapper;
import com.xiaour.spring.boot.mapper.UserInfoMapper;
import com.xiaour.spring.boot.response.ResultRsp;
import com.xiaour.spring.boot.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<ResultRsp> getResultByUser(int user) {
        List<Result> resultList = resultMapper.queryResultByUser(user);
        List<ResultRsp> resultRspList = new ArrayList<>();
        for (Result result : resultList) {
            ResultRsp resultRsp = new ResultRsp();
            resultRsp.setUserName(userInfoMapper.selectByPrimaryKey(result.getUserId()).getName());
            resultRsp.setExamName(examMapper.queryExamById(result.getExamId()).getName());
            resultRsp.setScore(result.getScore());
            resultRspList.add(resultRsp);
        }
        return resultRspList;
    }

    @Override
    public List<ResultRsp> getResultByExam(int exam) {
        List<Result> resultList = resultMapper.queryResultByExam(exam);
        List<ResultRsp> resultRspList = new ArrayList<>();
        for (Result result : resultList) {
            ResultRsp resultRsp = new ResultRsp();
            resultRsp.setUserId(result.getUserId());
            resultRsp.setUserName(userInfoMapper.selectByPrimaryKey(result.getUserId()).getName());
            resultRsp.setExamName(examMapper.queryExamById(result.getExamId()).getName());
            resultRsp.setScore(result.getScore());
            resultRspList.add(resultRsp);
        }
        return resultRspList;
    }
}
