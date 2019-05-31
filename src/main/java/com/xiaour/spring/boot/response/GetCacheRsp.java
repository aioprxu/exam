package com.xiaour.spring.boot.response;

import java.util.List;

public class GetCacheRsp {

    private List<QuestionRsp> questionList;

    public List<QuestionRsp> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionRsp> questionList) {
        this.questionList = questionList;
    }
}
