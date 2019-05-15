package com.xiaour.spring.boot.mapper;

import com.xiaour.spring.boot.entity.Exam;

import java.util.List;

public interface ExamMapper {
    List<Exam> queryAllExam();
    List<Exam> queryExamByModel(int model);
    Exam queryExamById(int exam);
    boolean updateExam(Exam exam);
    boolean addExam(Exam exam);
    boolean delExam(int examId);
}
