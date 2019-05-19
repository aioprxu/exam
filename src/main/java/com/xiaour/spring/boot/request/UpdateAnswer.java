package com.xiaour.spring.boot.request;

import com.xiaour.spring.boot.entity.Answer;

import java.util.List;

public class UpdateAnswer {
    private List<Answer> answerList;

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

}
