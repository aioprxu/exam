package com.xiaour.spring.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.entity.*;
import com.xiaour.spring.boot.mapper.*;
import com.xiaour.spring.boot.request.SubmitPaperReq;
import com.xiaour.spring.boot.response.GetPaperRsp;
import com.xiaour.spring.boot.response.QuestionRsp;
import com.xiaour.spring.boot.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private PaperQuestionMapper paperQuestionMapper;

    @Autowired
    private ResultMapper resultMapper;


    @Override
    public GetPaperRsp getPaper(int exam) {
        GetPaperRsp getPaperRsp = new GetPaperRsp();
        Exam exam1 = examMapper.queryExamById(exam);
        int paperId = exam1.getPaperId();
        List<QuestionRsp> questionRsps = new ArrayList<>();
        for (Integer questionId : paperQuestionMapper.queryQuestionByPaper(paperId)) {
            QuestionRsp questionRsp = new QuestionRsp();
            Question question = questionMapper.getQuestionById(questionId);
            questionRsp.setOptions(Arrays.asList(question.getOptions().split(",")));
            questionRsp.setQuestionstem(question.getQuestionstem());
            questionRsp.setQuestionType(question.getQuestionType());
            questionRsps.add(questionRsp);
        }
        getPaperRsp.setQuestionRspList(questionRsps);
        getPaperRsp.setStopTime(exam1.getStopTime());
        getPaperRsp.setStartTime(exam1.getStartTime());
        return getPaperRsp;
    }

    @Override
    public boolean saveAnswer(SubmitPaperReq req) {
        Integer paperId = examMapper.queryExamById(req.getExamId()).getPaperId();
        List<Integer> questionList = paperQuestionMapper.queryQuestionByPaper(paperId);
        int score = 0;
        for (int i = 0; i<req.getAnswers().size(); i++){
            Question question = questionMapper.getQuestionById(questionList.get(i));
            Answer answer = new Answer();
            if (question.getAnswer().equals(req.getAnswers().get(i))) {
                answer.setScore(3);
                score+=3;
            } else {
                answer.setScore(0);
            }
            answer.setExamId(req.getExamId());
            answer.setUserId(req.getUserId());
            answer.setQuestionId(question.getId());
            answer.setAnswer(req.getAnswers().get(i));
            answerMapper.insertAnswer(answer);
        }
        Result result = new Result();
        result.setExamId(req.getExamId());
        result.setScore(score);
        result.setUserId(req.getUserId());
        resultMapper.addResult(result);
        return true;
    }
}
