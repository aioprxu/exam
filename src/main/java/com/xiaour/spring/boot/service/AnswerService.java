package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> getAnswer(int exam, int user);

    boolean updateAnswer(Answer answer);

}
