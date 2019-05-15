package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.Result;

import java.util.List;

public interface ResultMapper {
    boolean addResult(Result result);
    boolean delResult(int id);
    boolean updateResult(Result result);
    List<Result> queryAllResult();
    List<Result> queryResultByExam(int exam);
    List<Result> queryResultByUser(int user);
}
