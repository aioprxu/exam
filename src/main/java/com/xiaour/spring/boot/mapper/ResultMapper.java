package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResultMapper {
    boolean addResult(Result result);
    boolean delResult(@Param("exam") int exam, @Param("user") int user);
    boolean updateResult(Result result);
    List<Result> queryAllResult();
    List<Result> queryResultByExam(int exam);
    List<Result> queryResultByUser(int user);
}
