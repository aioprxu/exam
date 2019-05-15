package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Exam;

import java.util.List;

public interface ExamInfoService {
    List<Exam> getExamInfo(int userId);
}
