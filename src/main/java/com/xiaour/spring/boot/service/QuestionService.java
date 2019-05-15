package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Question;

import java.util.List;

public interface QuestionService {
    boolean addQuestion(Question question);
    boolean delQuestion(int questionId);
    boolean updateQuestion(Question question);
    List<Question> getQuestion();
    List<Question> getQuestionByModel(int model);
    Question getQuestionById(int id);
    List<Question> getQuestionByPaper(int paper);
}
