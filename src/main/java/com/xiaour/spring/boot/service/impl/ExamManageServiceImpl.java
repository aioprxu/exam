package com.xiaour.spring.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaour.spring.boot.entity.Exam;
import com.xiaour.spring.boot.mapper.ExamMapper;
import com.xiaour.spring.boot.mapper.ExamUserMapper;
import com.xiaour.spring.boot.request.ExamReq;
import com.xiaour.spring.boot.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExamManageServiceImpl implements ExamManageService {

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private ExamUserMapper examUserMapper;

    @Override
    public List<ExamReq> getAllExam() {
        List<ExamReq> examReqList = new ArrayList<>();
        for (Exam exam : examMapper.queryAllExam()){
            ExamReq examReq = new ExamReq();
            examReq.setExamId(exam.getExamId());
            examReq.setIsOpen(exam.getIsOpen());
            examReq.setName(exam.getName());
            examReq.setPaperId(exam.getPaperId());
            examReq.setStartTime(exam.getStartTime());
            examReq.setStopTime(exam.getStopTime());
            examReq.setModelId(exam.getModelId());
            String userId = JSON.toJSONString(examUserMapper.queryUserByExam(exam.getExamId()));
            userId = userId.replace("[","");
            userId = userId.replace("]","");
            examReq.setUserId(userId);
            examReqList.add(examReq);
        }
        return examReqList;
    }

    @Override
    public List<ExamReq> getExamByModel(int modelId) {
        List<ExamReq> examReqList = new ArrayList<>();
        for (Exam exam : examMapper.queryExamByModel(modelId)){
            ExamReq examReq = new ExamReq();
            examReq.setExamId(exam.getExamId());
            examReq.setIsOpen(exam.getIsOpen());
            examReq.setName(exam.getName());
            examReq.setPaperId(exam.getPaperId());
            examReq.setStartTime(exam.getStartTime());
            examReq.setStopTime(exam.getStopTime());
            examReq.setModelId(exam.getModelId());
            String userId = JSON.toJSONString(examUserMapper.queryUserByExam(exam.getExamId()));
            userId = userId.replace("[","");
            userId = userId.replace("]","");
            examReq.setUserId(userId);
            examReqList.add(examReq);
        }
        return examReqList;
    }

    @Override
    public List<ExamReq> getExamByUser(int userId) {
        List<ExamReq> examReqList = new ArrayList<>();
        for(Integer examId : examUserMapper.queryExamByUser(userId)){
            Exam exam = examMapper.queryExamById(examId);
            System.out.println(JSON.toJSONString(examId));
            ExamReq examReq = new ExamReq();
            examReq.setExamId(exam.getExamId());
            examReq.setIsOpen(exam.getIsOpen());
            examReq.setName(exam.getName());
            examReq.setPaperId(exam.getPaperId());
            examReq.setStartTime(exam.getStartTime());
            examReq.setStopTime(exam.getStopTime());
            examReq.setModelId(exam.getModelId());
            examReq.setUserId(String.valueOf(userId));
            examReqList.add(examReq);
        }
        return examReqList;
    }

    @Override
    public boolean updateExam(ExamReq exam) {
        examUserMapper.delExamUser(exam.getExamId());
        List<String> userList = Arrays.asList(exam.getUserId().split(","));
        for(String userId : userList){
            examUserMapper.addExamUser(exam.getExamId(), Integer.parseInt(userId));
        }
        Exam exam1 = new Exam();
        exam1.setExamId(exam.getExamId());
        exam1.setIsOpen(exam.getIsOpen());
        exam1.setName(exam.getName());
        exam1.setPaperId(exam.getPaperId());
        exam1.setStartTime(exam.getStartTime());
        exam1.setStopTime(exam.getStopTime());
        exam1.setModelId(exam.getModelId());
        return examMapper.updateExam(exam1);
    }

    @Override
    public boolean addExam(ExamReq exam) {
        List<String> userList = Arrays.asList(exam.getUserId().split(","));
        Exam exam1 = new Exam();
        exam1.setExamId(exam.getExamId());
        exam1.setIsOpen(exam.getIsOpen());
        exam1.setName(exam.getName());
        exam1.setPaperId(exam.getPaperId());
        exam1.setStartTime(exam.getStartTime());
        exam1.setStopTime(exam.getStopTime());
        exam1.setModelId(exam.getModelId());
        examMapper.addExam(exam1);
        for(String userId : userList){
            examUserMapper.addExamUser(exam1.getExamId(), Integer.parseInt(userId));
        }
        return true;
    }

    @Override
    public boolean delExam(int examId) {
        examUserMapper.delExamUser(examId);
        return examMapper.delExam(examId);
    }
}
