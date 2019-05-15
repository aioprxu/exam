package com.xiaour.spring.boot.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamUserMapper {

    boolean addExamUser(@Param("exam") int exam, @Param("user") int user);

    boolean delExamUser(int exam);

    List<Integer> queryExamByUser(int user);

    List<Integer> queryUserByExam(int exam);
}
