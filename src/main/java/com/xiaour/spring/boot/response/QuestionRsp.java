package com.xiaour.spring.boot.response;

import java.util.List;

public class QuestionRsp {
    private String questionstem;
    private List<String> options;
    private int questionType;

    public String getQuestionstem() {
        return questionstem;
    }

    public void setQuestionstem(String questionstem) {
        this.questionstem = questionstem;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }
}
