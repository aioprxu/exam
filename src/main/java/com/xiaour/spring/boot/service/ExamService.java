package com.xiaour.spring.boot.service;

import com.xiaour.spring.boot.entity.Answer;
import com.xiaour.spring.boot.entity.Paper;
import com.xiaour.spring.boot.request.SubmitPaperReq;
import com.xiaour.spring.boot.response.GetPaperRsp;

import java.util.List;

public interface ExamService {
    GetPaperRsp getPaper(int exam);
    boolean saveAnswer(SubmitPaperReq req);
}
