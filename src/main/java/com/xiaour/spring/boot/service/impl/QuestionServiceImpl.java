package com.xiaour.spring.boot.service.impl;

import com.xiaour.spring.boot.entity.Question;
import com.xiaour.spring.boot.mapper.PaperQuestionMapper;
import com.xiaour.spring.boot.mapper.QuestionMapper;
import com.xiaour.spring.boot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private PaperQuestionMapper paperQuestionMapper;

    @Override
    public boolean addQuestion(Question question) {
        return questionMapper.addQuestion(question);
    }

    @Override
    public boolean delQuestion(int questionId) {
        return questionMapper.delQuestion(questionId);
    }

    @Override
    public boolean updateQuestion(Question question) {
        return questionMapper.updateQuestion(question);
    }

    @Override
    public List<Question> getQuestion() {
        return questionMapper.questionList();
    }

    @Override
    public List<Question> getQuestionByModel(int model) {
        return questionMapper.getQuestionByModel(model);
    }

    @Override
    public Question getQuestionById(int id) {
        return questionMapper.getQuestionById(id);
    }

    @Override
    public List<Question> getQuestionByPaper(int paper) {
        List<Question> questionList = new ArrayList<>();
        for(Integer questionId : paperQuestionMapper.queryQuestionByPaper(paper)) {
            questionList.add(questionMapper.getQuestionById(questionId));
        }
        return questionList;
    }
}
