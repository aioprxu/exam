package com.xiaour.spring.boot.response;


import java.util.Date;
import java.util.List;

public class GetPaperRsp {
    private Date startTime;
    private Date stopTime;
    private List<QuestionRsp> questionRspList;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public List<QuestionRsp> getQuestionRspList() {
        return questionRspList;
    }

    public void setQuestionRspList(List<QuestionRsp> questionRspList) {
        this.questionRspList = questionRspList;
    }
}
