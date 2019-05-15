package com.xiaour.spring.boot.request;

import com.xiaour.spring.boot.entity.Answer;
import com.xiaour.spring.boot.entity.Question;

import java.util.List;

public class SubmitPaperReq {
    private List<String> answers;

    private int userId;

    private int examId;

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
