package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Exam;
import com.xiaour.spring.boot.request.ExamReq;

import java.util.List;

public interface ExamManageService {
    List<ExamReq> getAllExam();
    List<ExamReq> getExamByModel(int modelId);
    List<ExamReq> getExamByUser(int userId);
    boolean updateExam(ExamReq exam);
    boolean addExam(ExamReq exam);
    boolean delExam(int examId);
}
