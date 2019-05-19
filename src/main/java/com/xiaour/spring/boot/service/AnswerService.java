package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Answer;
import com.xiaour.spring.boot.request.UpdateAnswer;
import com.xiaour.spring.boot.response.GetAnswerRsp;

import java.util.List;

public interface AnswerService {

    List<GetAnswerRsp> getAnswer(int exam, int user);

    boolean updateAnswer(UpdateAnswer updateAnswer);

}
