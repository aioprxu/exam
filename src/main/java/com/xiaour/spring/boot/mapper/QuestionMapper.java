package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.Paper;
import com.xiaour.spring.boot.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    List<Question> questionList();

    List<Question> getQuestionByType(String type);

    List<Question> getQuestionByModel(int model);

    Question getQuestionById(int id);

    List<Question> getQuestionByModelAndType(@Param("model") int model, @Param("type") int type);

    boolean addQuestion(Question question);

    boolean delQuestion(int id);

    boolean updateQuestion(Question question);

}
