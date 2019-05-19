package com.xiaour.spring.boot.service.impl;

import com.xiaour.spring.boot.entity.Answer;
import com.xiaour.spring.boot.entity.Question;
import com.xiaour.spring.boot.entity.Result;
import com.xiaour.spring.boot.mapper.AnswerMapper;
import com.xiaour.spring.boot.mapper.QuestionMapper;
import com.xiaour.spring.boot.mapper.ResultMapper;
import com.xiaour.spring.boot.request.UpdateAnswer;
import com.xiaour.spring.boot.response.GetAnswerRsp;
import com.xiaour.spring.boot.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ResultMapper resultMapper;

    @Override
    public List<GetAnswerRsp> getAnswer(int exam, int user) {
        List<Answer> answerList = answerMapper.getAnswer(exam, user);
        List<GetAnswerRsp> answerRsps = new ArrayList<>();
        for(Answer answer : answerList) {
            GetAnswerRsp getAnswerRsp = new GetAnswerRsp();
            getAnswerRsp.setAnswer(answer.getAnswer());
            getAnswerRsp.setScore(answer.getScore());
            getAnswerRsp.setTitle(questionMapper.getQuestionById(answer.getQuestionId()).getQuestionstem());
            getAnswerRsp.setExamId(exam);
            getAnswerRsp.setUserId(user);
            getAnswerRsp.setId(answer.getId());
            getAnswerRsp.setQuestionId(answer.getQuestionId());
            answerRsps.add(getAnswerRsp);
        }
        return answerRsps;
    }

    @Override
    public boolean updateAnswer(UpdateAnswer updateAnswer) {
        int score = 0;
        int exam = 0;
        int user = 0;
        for (Answer answer : updateAnswer.getAnswerList()){
            answerMapper.updateAnswer(answer);
            score+=answer.getScore();
            exam = answer.getExamId();
            user = answer.getUserId();
        }
        Result result = new Result();
        result.setExamId(exam);
        result.setScore(score);
        result.setUserId(user);
        resultMapper.delResult(exam, user);
        resultMapper.addResult(result);
        return true;
    }
}
