package com.xiaour.spring.boot.service.impl;

import com.xiaour.spring.boot.entity.Exam;
import com.xiaour.spring.boot.entity.Paper;
import com.xiaour.spring.boot.entity.Question;
import com.xiaour.spring.boot.mapper.ExamMapper;
import com.xiaour.spring.boot.mapper.PaperMapper;
import com.xiaour.spring.boot.mapper.PaperQuestionMapper;
import com.xiaour.spring.boot.mapper.QuestionMapper;
import com.xiaour.spring.boot.request.AddPaperReq;
import com.xiaour.spring.boot.request.PaperReq;
import com.xiaour.spring.boot.service.ExamService;
import com.xiaour.spring.boot.service.MakePaperService;
import com.xiaour.spring.boot.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private PaperQuestionMapper paperQuestionMapper;

    @Autowired
    private MakePaperService makePaperService;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public boolean addPaper(AddPaperReq addPaperReq) {
        Paper paper = new Paper();
        paper.setModelId(addPaperReq.getModelId());
        paper.setName(addPaperReq.getName());
        paperMapper.addPaper(paper);
        List<Question> questionList = makePaperService.getPaper(addPaperReq.getModelId());
        for(Question question : questionList){
            paperQuestionMapper.addQuestion(paper.getPaperId(), question.getId());
        }
        return true;
    }

    @Override
    public boolean delPaper(int paperId) {
        return paperMapper.delPaper(paperId);
    }

    @Override
    public boolean updatePaper(PaperReq paperReq) {
        paperQuestionMapper.delPaper(paperReq.getPaperId());
        List<String> questionList = Arrays.asList(paperReq.getQuestionId().split(","));
        for(String questionId : questionList) {
            paperQuestionMapper.addQuestion(paperReq.getPaperId(), Integer.parseInt(questionId));
        }
        return true;
    }

    @Override
    public List<Paper> getPaperByModel(int modelId) {
        return paperMapper.queryPaperByModel(modelId);
    }

    @Override
    public List<Paper> getAllPaper() {
        return paperMapper.queryAllPaper();
    }

    @Override
    public List<Question> getFile(int examId) {
        Exam exam = examMapper.queryExamById(examId);
        List<Integer> questions = paperQuestionMapper.queryQuestionByPaper(exam.getPaperId());
        List<Question> questionList = new ArrayList<>();
        for(Integer q : questions){
            questionList.add(questionMapper.getQuestionById(q));
        }
        return questionList;
    }


}
