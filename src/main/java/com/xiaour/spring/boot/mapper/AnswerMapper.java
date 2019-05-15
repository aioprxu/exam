package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerMapper {

    boolean insertAnswer(Answer answer);

    List<Answer> getAnswer(@Param("userId") int userId, @Param("examId") int examId);

}
