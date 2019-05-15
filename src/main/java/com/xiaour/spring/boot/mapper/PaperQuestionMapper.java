package com.xiaour.spring.boot.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperQuestionMapper {

    List<Integer> queryQuestionByPaper(int paper);

    boolean addQuestion(@Param("paper") int paper, @Param("question") int question);

    boolean delPaper(int paper);

}
